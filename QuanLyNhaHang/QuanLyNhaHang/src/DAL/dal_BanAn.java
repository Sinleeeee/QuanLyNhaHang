/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.TrangThai_Dat;
import Model_Hiber.BanAn;
import Model_Hiber.Cthd;
import Model_Hiber.DatBan;
import Model_Hiber.HoaDon;
import Model_Hiber.KhachHang;
import Model_Hiber.Loai;
import Model_Hiber.Monan;
import Model_Hiber.NhanVien;

import Utilities.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

/**
 *
 * @author admin
 */
public class dal_BanAn {
    
    public static List<BanAn> TenBanAn()
         {
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  List<BanAn> BanAnList = session.createQuery("FROM BanAn").list();
                    return BanAnList;
                } catch (Exception e) {
                    return null;
                } finally {
                    session.close();
                }
             
         }
    
    
    public static int setColorTrangThaiBan(String tenban)
         {
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
               
                   List<DatBan> BanAnList = session.createQuery("FROM DatBan WHERE banAn.tenBan=:tenban").setParameter("tenban", tenban).list();
                  if(!BanAnList.isEmpty())
                  {
                      
                      for(DatBan item: BanAnList)
                      {
                          
                          if(item.getTrangThai().equals("Hoat dong"))
                          {
                              return 1;
                          }
                          else if(item.getTrangThai().equals("Da dat"))
                          {
                              return 2;
                          }
                      }
                  }
                    
                } catch (Exception e) {
                    return 0;
                } finally {
                    session.close();
                }
                return 0;
             
         }
    
    public static  List<BanAn> getBanTrong()
         {
          
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                            List<BanAn> BanAnList = session.createQuery("SELECT new Model_Hiber.BanAn(b.maBan,b.tenBan) FROM BanAn b WHERE  b.maBan NOT IN (SELECT d.banAn.maBan FROM DatBan d WHERE d.trangThai='Hoat dong' OR d.trangThai='Da dat')")
                            .list();
                            return BanAnList;
                    
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return  null;
                } finally {
                    session.close();
                }
              
             
         }
    
    
    
    
        public static  List<BanAn> getBanAn_Change()
         {
          
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                           List<BanAn> BanAnList = session.createQuery("SELECT new Model_Hiber.BanAn(d.banAn.maBan,d.banAn.tenBan)FROM DatBan d")

                                .list();
                            return BanAnList;
                    
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return  null;
                } finally {
                    session.close();
                }
              
             
         }
        
        
         public static  List<BanAn> getBanAn_Ghep()
         {
          
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                           List<BanAn> BanAnList = session.createQuery("SELECT new Model_Hiber.BanAn(d.banAn.maBan,d.banAn.tenBan)FROM DatBan d WHERE d.trangThai='Hoat dong'")

                                .list();
                            return BanAnList;
                    
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return  null;
                } finally {
                    session.close();
                }
              
             
         }
    
    
    public static  List<BanAn> locTrangThai(String tentrangthai)
         {
          
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    if(tentrangthai =="Trống")
                    {
                            List<BanAn> BanAnList = session.createQuery("SELECT new Model_Hiber.BanAn(b.maBan,b.tenBan) FROM BanAn b WHERE  b.maBan NOT IN (SELECT d.banAn.maBan FROM DatBan d WHERE d.trangThai='Hoat dong' OR d.trangThai='Da dat')")
                            .list();
                           
                            
                            return BanAnList;
                    }else if(tentrangthai =="Hoạt động")
                    {
                         
                            List<BanAn> BanAnList = session.createQuery("SELECT new Model_Hiber.BanAn(b.maBan,b.tenBan)FROM BanAn b, DatBan d WHERE d.trangThai=:tentt and d.banAn.maBan=b.maBan ").setParameter("tentt", "Hoat dong").list();
                            
                            return BanAnList ;
                    }
                    else if(tentrangthai=="Đã đặt")
                    {
                       
                             List<BanAn> BanAnList = session.createQuery("SELECT new Model_Hiber.BanAn(b.maBan,b.tenBan)FROM BanAn b, DatBan d WHERE d.trangThai=:tentt and d.banAn.maBan=b.maBan  ").setParameter("tentt", "Da dat").list();
                            return BanAnList;
                    }
                    else
                    {
                            List<BanAn> BanAnList = session.createQuery("FROM BanAn").list();
                            return BanAnList;
                    }   
                     
                    
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return  null;
                } finally {
                    session.close();
                }
              
             
         }
    
    
    public  static List<TrangThai_Dat> loadthongtin (String tenban)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                  List<TrangThai_Dat> BanAnList = session.createQuery("SELECT new Model.TrangThai_Dat(k.tenKh, k.sdt, d.slkhach, d.thoiGianVao,d.maDatBan)FROM DatBan d INNER JOIN d.khachHang k WHERE d.banAn.tenBan = :name").setParameter("name", tenban).list();
                     
                  return BanAnList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
    
    public static int delBanDat (String idHDD)
    {
           Session session = HibernateUtil.getSessionFactory().openSession();
         
          try {
              session.beginTransaction();
          
              String hql = "delete from DatBan where maDatBan = :id";
              Query query = session.createQuery(hql);
              query.setParameter("id", idHDD);
              int result = query.executeUpdate();
            
              session.getTransaction().commit();
              return result;
           
          } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
              
              
          } finally {
              session.close();
               return 0;
          }
    }
    
    
      public static String GetTenBan(String id) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                        String idBan = (String) session.createQuery("SELECT b.tenBan FROM BanAn b WHERE b.maBan =:name")
                                .setParameter("name", id)
                            .uniqueResult();
                            return idBan;
                        
                  
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return "null";
                } finally {
                    session.close();
                }
            }
    
      
       public static void getTrangThaiBan(String tenban_to, String tenban_from) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                        List<DatBan>  trangthai_to =  session.createQuery("FROM  DatBan d WHERE d.banAn.tenBan=:name")
                             .setParameter("name", tenban_to)
                            .list();
                       // JOptionPane.showMessageDialog(null,tenban_to);

                        String idBanNew = (String) session.createQuery("SELECT b.maBan FROM  BanAn b WHERE b.tenBan=:name1")
                                .setParameter("name1", tenban_from)
                            .uniqueResult();
                        
                  
                       for (DatBan item: trangthai_to )
                       {
                          //  JOptionPane.showMessageDialog(null,item.getBanAn().getMaBan());
                            if(item.getTrangThai().equals("Da dat"))
                               {
                              //     JOptionPane.showMessageDialog(null,item.getTrangThai());
                                //Sửa mã bàn mới
                                  session.beginTransaction();
                                BanAn ba=(BanAn)  session.get (BanAn.class,idBanNew );
                                DatBan dold= (DatBan)  session.get (DatBan.class,item.getMaDatBan() );
                                dold.setBanAn(ba);
                                session.update(dold);
                                session.getTransaction().commit();
                                
                                
                           }
                            else if(item.getTrangThai().equals("Hoat dong"))
                            {
                            String swap=item.getBanAn().getMaBan();
                                //Sửa mã bàn mới cho đặt bàn
                                  session.beginTransaction();
                                BanAn ba=(BanAn)  session.get (BanAn.class,idBanNew );
                                DatBan dold= (DatBan)  session.get (DatBan.class,item.getMaDatBan() );
                                dold.setBanAn(ba);
                                session.update(dold);
                                session.getTransaction().commit();
                               // JOptionPane.showMessageDialog(null,item.getBanAn().getMaBan());
                                //Lấy thông tin của HoaDon_To
                                List<HoaDon> hoadon_to = session.createQuery("FROM HoaDon h WHERE h.ghiChu =:ghiChu AND h.banAn.maBan = :name2")
                             .setParameter("ghiChu", "Chưa thanh toán")
                             .setParameter("name2", swap)  
                             .list();
                                  
                                //Sửa mã bàn
                                for (HoaDon item1:  hoadon_to)
                                {session.beginTransaction();
                              
                                    HoaDon hd= (HoaDon)  session.get (HoaDon.class,item1.getMaHd() );
                                    hd.setBanAn(ba);
                                    
                                    //session.update(hd);
                                    session.getTransaction().commit();
                                    
                                }
                                
                                
                            }
                                
                            
                            
                       }
                       JOptionPane.showMessageDialog(null, "Thay đổi thành công");
                   
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                  
                } finally {
                    session.close();
                }
            }
    
       
       
         public  static void Ghep_TH1 (String ban1, String ban2)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    //lấy mã bàn.
                  String maban1 = (String) session.createQuery("SELECT b.maBan FROM BanAn b WHERE b.tenBan=:name")
                          .setParameter("name", ban1)
                          .uniqueResult();
                  String maban2  = (String) session.createQuery("SELECT b.maBan FROM BanAn b WHERE b.tenBan=:name1")
                          .setParameter("name1", ban2)
                          .uniqueResult();
                  
                  //lấy mã hóa đơn
                  
                   String maHD1 = (String) session.createQuery("SELECT h.maHd FROM HoaDon h WHERE h.banAn.maBan=:name3 AND h.ghiChu=:ghiChu3")
                          .setParameter("name3",  maban1)
                          .setParameter("ghiChu3", "Chưa thanh toán")
                          .uniqueResult();
                  String maHD2 = (String) session.createQuery("SELECT h.maHd FROM HoaDon h WHERE h.banAn.maBan=:name4 AND h.ghiChu=:ghiChu4")
                          .setParameter("name4",  maban2)
                          .setParameter("ghiChu4", "Chưa thanh toán")
                          .uniqueResult();
                  
                  //Sửa CTHD
                  
                  List<Cthd> listCTHD =  session.createQuery("FROM Cthd c WHERE c.hoaDon.maHd =:name5")
                          .setParameter("name5",maHD1)
                          .list();
                  HoaDon hd= (HoaDon) session.get (HoaDon.class,maHD2 );
                  
                 for (Cthd item:listCTHD )
                 {
                     //sửa
                     session.beginTransaction();
                     Cthd cthd =(Cthd) session.get (Cthd.class,item.getMaCthd() );
                     cthd.setHoaDon(hd);
                     session.update(cthd);
                     session.getTransaction().commit();
                 }
                 
                 //Xóa HD
                 session.beginTransaction();
                 HoaDon hddel= (HoaDon) session.get (HoaDon.class,maHD1);
                 session.delete(hddel);
                 session.getTransaction().commit();
                 //Xóa Đặt bàn
                  session.beginTransaction();
                  String madb1= (String) session.createQuery("SELECT d.maDatBan FROM DatBan d WHERE d.banAn.tenBan=:name6")
                          .setParameter("name6", ban1)
                          .uniqueResult();
                  
                 DatBan db= (DatBan) session.get (DatBan.class,madb1);
                 session.delete(db);
                 session.getTransaction().commit();
                 
                   JOptionPane.showMessageDialog(null, "Ghép bàn thành công");
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                   
                } finally {
                    session.close();
                }
    }
         
         
         public  static void Ghep_TH2 (String ban1, String ban2,String ban3)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                     //lấy mã bàn.
                  String maban1 = (String) session.createQuery("SELECT b.maBan FROM BanAn b WHERE b.tenBan=:name")
                          .setParameter("name", ban1)
                          .uniqueResult();
                  String maban2  = (String) session.createQuery("SELECT b.maBan FROM BanAn b WHERE b.tenBan=:name1")
                          .setParameter("name1", ban2)
                          .uniqueResult();
                   String maban3  = (String) session.createQuery("SELECT b.maBan FROM BanAn b WHERE b.tenBan=:name22")
                          .setParameter("name22", ban3)
                          .uniqueResult();
               
                    
                    //Tạo đặt bàn 3 (Mặc định là ban1)
                    List<DatBan> listDB_MD =  session.createQuery("FROM DatBan d WHERE d.banAn.tenBan=:name")
                          .setParameter("name", ban1)
                          .list();
                          //Tạo đặt bàn mới
                          
                    for (DatBan item: listDB_MD )
                    {
                        session.beginTransaction();
                         KhachHang kh= (KhachHang) session.get (KhachHang.class,item.getKhachHang().getMaKh());
                         BanAn ba=(BanAn) session.get (BanAn.class,maban3);
                         DatBan db = new DatBan();
                         db.setBanAn(ba);
                         db.setKhachHang(kh);
                         db.setMaDatBan("0000");
                         db.setSlkhach(item.getSlkhach());
                         db.setThoiGianVao(item.getThoiGianVao());
                         db.setTrangThai("Hoat dong");
                         session.save(db);
                        session.getTransaction().commit();
                    }
                    
                     
                    
                     //Tạo mã hóa đơn
                    ProcedureCall procedureCall = session.createStoredProcedureCall("GetNewMaHD");


                   procedureCall.registerParameter("NewMaHD", String.class, ParameterMode.OUT);

                    String idHDnew = (String) procedureCall.getOutputs().getOutputParameterValue("NewMaHD");
                  //  JOptionPane.showMessageDialog(null,  idHDnew);
                    //Tạo hóa đơn 3(Mặc định là từ ban1)
                    List<HoaDon> listHD_MD =  session.createQuery("FROM HoaDon d WHERE d.banAn.maBan =:maban11 AND d.ghiChu =:ghichuu ")
                          .setParameter("maban11",  maban1)
                          .setParameter("ghichuu", "Chưa thanh toán")
                          .list();
                    for(HoaDon item: listHD_MD)
                    {
                        session.beginTransaction();
                        NhanVien nv =(NhanVien) session.get (NhanVien.class,item.getNhanVien().getMaNv());
                        BanAn ba=(BanAn) session.get (BanAn.class,maban3);
                        
                        HoaDon hd= new HoaDon();
                        hd.setBanAn(ba);
                        hd.setNhanVien(nv);
                        hd.setNgayTao(item.getNgayTao());
                        hd.setTongTien(BigDecimal.ZERO);
                        hd.setMaHd("0000");
                        hd.setGhiChu("Chưa thanh toán");
                        session.save(hd);
                        session.getTransaction().commit();
                    }
                    
                  //lấy mã hóa đơn
                   String maHD1 = (String) session.createQuery("SELECT h.maHd FROM HoaDon h WHERE h.banAn.maBan=:name3 AND h.ghiChu=:ghiChu3")
                          .setParameter("name3",  maban1)
                          .setParameter("ghiChu3", "Chưa thanh toán")
                          .uniqueResult();
                  String maHD2 = (String) session.createQuery("SELECT h.maHd FROM HoaDon h WHERE h.banAn.maBan=:name4 AND h.ghiChu=:ghiChu4")
                          .setParameter("name4",  maban2)
                          .setParameter("ghiChu4", "Chưa thanh toán")
                          .uniqueResult();
                  
                  //Sửa CTHD
                  
                  List<Cthd> listCTHD1 =  session.createQuery("FROM Cthd c WHERE c.hoaDon.maHd =:name5")
                          .setParameter("name5",maHD1)
                          .list();
                  
                  List<Cthd> listCTHD2 =  session.createQuery("FROM Cthd c WHERE c.hoaDon.maHd =:name6")
                          .setParameter("name6",maHD2)
                          .list();

                //  JOptionPane.showMessageDialog(null,  maHD1+" "+maHD2);
                  HoaDon hd= (HoaDon) session.get (HoaDon.class, idHDnew);
                 // JOptionPane.showMessageDialog(null, "ALO"+ idHDnew);
                  //Chỉnh sửa CTHD1
                  
                      
                 for (Cthd item:listCTHD1 )
                 {// JOptionPane.showMessageDialog(null,  "Chỉnh sửa CTHD1: "+item.getMaCthd());
                     //sửa
                     session.beginTransaction();
                     Cthd cthd =(Cthd) session.get (Cthd.class,item.getMaCthd() );
                    cthd.setHoaDon(hd);
                       session.update(cthd);
                     session.getTransaction().commit();
                 }
                 
                    //Chỉnh sửa CTHD2
                 for (Cthd item1:listCTHD2 )
                 {//JOptionPane.showMessageDialog(null,  "Chỉnh sửa CTHD2: "+item1.getMaCthd());
                     //sửa
                     session.beginTransaction();
                     Cthd cthd =(Cthd) session.get (Cthd.class,item1.getMaCthd() );
                     cthd.setHoaDon(hd);
                     session.update(cthd);
                     session.getTransaction().commit();
                 }
                 
                 //Xóa HD
                 session.beginTransaction();
                 HoaDon hddel= (HoaDon) session.get (HoaDon.class,maHD1);
                 session.delete(hddel);
                 session.getTransaction().commit();
                 
                 
                 session.beginTransaction();
                 HoaDon hddel1= (HoaDon) session.get (HoaDon.class,maHD2);
                 session.delete(hddel1);
                 session.getTransaction().commit();
                 //Xóa Đặt bàn
                  session.beginTransaction();
                  String madb1= (String) session.createQuery("SELECT d.maDatBan FROM DatBan d WHERE d.banAn.tenBan=:name6")
                          .setParameter("name6", ban1)
                          .uniqueResult();
                  
                   String madb2= (String) session.createQuery("SELECT d.maDatBan FROM DatBan d WHERE d.banAn.tenBan=:name77")
                          .setParameter("name77", ban2)
                          .uniqueResult();
                 DatBan db= (DatBan) session.get (DatBan.class,madb1);
                 session.delete(db);
                 
                  DatBan db1= (DatBan) session.get (DatBan.class,madb2);
                 session.delete(db1);
                 
                 session.getTransaction().commit();
                 
                   JOptionPane.showMessageDialog(null, "Ghép bàn thành công");
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                   
                } finally {
                    session.close();
                }
    }
         
         
             
       
    
}
