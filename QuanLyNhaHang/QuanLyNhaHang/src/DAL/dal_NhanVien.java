/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model_Hiber.DangNhap;
import Model_Hiber.HoaDon;
import Model_Hiber.Hoadonnhap;
import Model_Hiber.Loai;
import Model_Hiber.Monan;
import Model_Hiber.NhanVien;
import Utilities.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

/**
 *
 * @author admin
 */
public class dal_NhanVien {
    
       public  static List<Object[]> loadthongtinNhanVien ()
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<Object[]> resultList  = session.createQuery("SELECT n.maNv,n.hoTen,n.sdt,n.cccd FROM NhanVien n ").list();

                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
       
          public  static List<DangNhap> loadAccount (String IDNV)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                   int idtk=  (int) session.createQuery(" SELECT  n.dangNhap.maDangNhap FROM NhanVien n WHERE  n.maNv=:name")
                         .setParameter("name", IDNV)
                         .uniqueResult();
                                            
                 List<DangNhap> resultList  = session.createQuery(" FROM DangNhap WHERE maDangNhap=:name1")
                         .setParameter("name1", idtk)
                         .list();

                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
          
            public static void insertNhanVien (String ten, String sdt,String cccd, String taikhoan, String matkhau) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    ProcedureCall procedureCall = session.createStoredProcedureCall("sp_InsertDangNhap");
                   procedureCall.registerParameter("MaDangNhap", int.class, ParameterMode.OUT);

                    int idDNnew = (int) procedureCall.getOutputs().getOutputParameterValue("MaDangNhap");
                  
                    //Tạo DangNhap
                  session.beginTransaction();
                  DangNhap dn = new DangNhap();
                  dn.setMaDangNhap(idDNnew);
                  dn.setTaiKhoan(taikhoan);
                  dn.setMatKhau(matkhau);
                  session.save(dn);
                  session.getTransaction().commit();
                    session.beginTransaction();
                  DangNhap  dangnhap = (DangNhap) session.get (DangNhap.class,idDNnew );
                    NhanVien nv= new NhanVien();
                    nv.setCccd(cccd);
                    nv.setDangNhap(dangnhap);
                    nv.setHoTen(ten);
                    nv.setSdt(sdt);
                    nv.setMaNv("0000");
                  session.save(nv);
                  session.getTransaction().commit();
                   JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
            
            
            
             public static void updateNhanVien (String idNv, String idacc,String ten, String sdt,String cccd, String taikhoan, String matkhau) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  //  JOptionPane.showMessageDialog(null, idacc);
                    //Tạo DangNhap
                  session.beginTransaction();
                  DangNhap  dn = (DangNhap) session.get (DangNhap.class,Integer.parseInt(idacc));
                  dn.setTaiKhoan(taikhoan);
                  dn.setMatKhau(matkhau);
                  session.update(dn);
                  session.getTransaction().commit();
                  
                  
                  
                    session.beginTransaction();
                  NhanVien   nv = (NhanVien ) session.get (NhanVien .class,idNv );
                    nv.setCccd(cccd);
                    nv.setHoTen(ten);
                    nv.setSdt(sdt);
                  session.update(nv);
                  session.getTransaction().commit();
                   JOptionPane.showMessageDialog(null, "Sửa nhân viên thành công");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
             
             
             
               public static void delNhanVien (String idNv, String idacc,String ten, String sdt,String cccd, String taikhoan, String matkhau) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                     
                    //get NULL cho HD
                    List<HoaDon>lstHD = session.createQuery(" FROM HoaDon h WHERE h.nhanVien.maNv=:name1 ")
                         .setParameter("name1", idNv)
                         .list();
              
                    NhanVien nv = (NhanVien) session.get (NhanVien.class,"NULL" );
               
                    if(!lstHD.isEmpty()) {
                        
                        for (HoaDon item:lstHD  )
                        {   session.beginTransaction();
                    
                            HoaDon hd=(HoaDon) session.get (HoaDon.class,item.getMaHd());
                            hd.setNhanVien(nv);
                            session.update(hd);
                            session.getTransaction().commit();
                        }
                    
                    } 
        
                   
                    
                    //get NULL cho HDN
               
                     List<Hoadonnhap>lstHDN = session.createQuery(" FROM Hoadonnhap h WHERE h.nhanVien.maNv=:name2 ")
                         .setParameter("name2", idNv)
                         .list();
                  
                     if(!lstHDN.isEmpty()) 
                     {
                           for (Hoadonnhap item:lstHDN )
                            {   session.beginTransaction();
                        
                                Hoadonnhap hd=(Hoadonnhap) session.get (Hoadonnhap.class,item.getMaHdn());
                                hd.setNhanVien(nv);
                                session.update(hd);
                                session.getTransaction().commit();
                            }
                     }
                
                  //Xóa nhanvien
                    session.beginTransaction();
                    
                  NhanVien nvv =(NhanVien) session.get (NhanVien.class,idNv);
                  session.delete(nvv);
                
                  session.getTransaction().commit();
                
                    //xóa DangNhap
                  session.beginTransaction();
                  DangNhap  dn = (DangNhap) session.get (DangNhap.class,Integer.parseInt(idacc));
                  session.delete(dn);
                  session.getTransaction().commit();
                  
                    
                   JOptionPane.showMessageDialog(null, "xóa nhân viên thành công");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
               
               
               
                public  static List<NhanVien> getDangNhap (String tentk, String matkhau)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<NhanVien> listNV  = session.createQuery("FROM NhanVien n WHERE n.dangNhap.taiKhoan=:name1 AND n.dangNhap.matKhau=:name2 ")
                         .setParameter("name1", tentk)
                         .setParameter("name2", matkhau)
                         .list();
                 
                  return listNV ;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
             
          
}
