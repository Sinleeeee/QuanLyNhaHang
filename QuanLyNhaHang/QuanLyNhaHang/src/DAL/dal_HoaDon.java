/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.ThongTin_HD;
import Model.TrangThai_Dat;
import Model_Hiber.BanAn;
import Model_Hiber.Cthd;
import Model_Hiber.Duockhuyenmai;
import Model_Hiber.HoaDon;
import Model_Hiber.Monan;
import Model_Hiber.NhanVien;
import Utilities.HibernateUtil;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.persistence.ParameterMode;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

/**
 *
 * @author admin
 */
public class dal_HoaDon {
    
       public  static List<ThongTin_HD> loadthongtinHD (String tenban)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                  List<ThongTin_HD> list = session.createQuery("SELECT new Model.ThongTin_HD(b.tenBan, h.maHd,k.tenKh,k.sdt,h.tongTien,d.maDatBan ) FROM DatBan d, KhachHang k,BanAn b, HoaDon h WHERE h.ghiChu=:ghichu AND d.banAn.maBan=b.maBan and h.banAn.maBan= b.maBan and d.khachHang.maKh = k.maKh and d.banAn.tenBan=:name")
                          .setParameter("name", tenban)
                          .setParameter("ghichu", "Chưa thanh toán")
                          .list();
//                     for (ThongTin_HD item:list )
//                     {
//                          JOptionPane.showMessageDialog(null, item.getTenKH()+item.getTongtien());
//                     }
                  
                  return list;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
       
       
          public  static List<Object[]> loadthongtinCTHD (String tenmon)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<Object[]> resultList  = session.createQuery("SELECT m.tenMonAn, c.donGia,c.sl,c.thanhTien,c.maCthd FROM Cthd c, HoaDon h, Monan m WHERE h.maHd=:name AND c.hoaDon.maHd=h.maHd AND c.monan.maMon=m.maMon").setParameter("name", tenmon).list();
//                     for (ThongTin_HD item:list )
//                     {
//                          JOptionPane.showMessageDialog(null, item.getTenKH()+item.getTongtien());
//                     }
                  
                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
          
          
          public static void insertHoaDon (Date ngaytao, String ghichu, String TenNV, String TenBan)
        {
               Session session = HibernateUtil.getSessionFactory().openSession();

              try {
                  
                 String idNV = session.createQuery("SELECT n.maNv FROM NhanVien n WHERE n.hoTen = :name")
                     .setParameter("name", TenNV)
                     .uniqueResult().toString();

                String idBan = session.createQuery("SELECT b.maBan FROM BanAn b WHERE b.tenBan = :name1")
                                      .setParameter("name1", TenBan)
                                      .uniqueResult().toString();

                  
                  session.beginTransaction();
                  NhanVien nhanVien = (NhanVien) session.get(NhanVien.class, idNV);
                  BanAn banAn = (BanAn) session.get(BanAn.class, idBan);
                  
                    String hql = "update DatBan set trangThai='Hoat dong' where banAn.maBan=:name2 ";
                    Query query = session.createQuery(hql);
                    query.setParameter("name2", idBan);
                    int result = query.executeUpdate();
                  session.getTransaction().commit();
                  session.beginTransaction();
                HoaDon hd= new HoaDon();
                   hd.setMaHd("0000");
                   hd.setNgayTao(ngaytao);
                   hd.setGhiChu(ghichu);
                   hd.setNhanVien(nhanVien);
                   hd.setBanAn(banAn);
                   hd.setTongTien(BigDecimal.valueOf(0.0));
                  
                  
                   session.save(hd);
                 
                  session.getTransaction().commit();
                  

              } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());


              } finally {
                  session.close();
                  
              }
        }
          
          
             public static void insertCTHD (String tenmon, String maHD, String soluong, String thanhtien, String dongia) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                    String idmon = session.createQuery("SELECT m.maMon FROM Monan m WHERE m.tenMonAn = :name1")
                                      .setParameter("name1", tenmon)
                                      .uniqueResult().toString();
                   // JOptionPane.showMessageDialog(null, tenmon+maHD+soluong+" "+thanhtien+" "+dongia+idmon);
                  session.beginTransaction();
                  Monan mon = (Monan) session.get(Monan.class, idmon );
                  HoaDon hd = (HoaDon) session.get(HoaDon.class, maHD);
                  
                  Cthd cthd=new Cthd();
                  cthd.setMaCthd("0000");
                  cthd.setHoaDon(hd);
                  cthd.setMonan(mon);
                  cthd.setSl(Integer.parseInt(soluong) );
                  cthd.setDonGia( BigDecimal.valueOf(Double.parseDouble(dongia)));
                  cthd.setThanhTien(BigDecimal.valueOf(Double.parseDouble(thanhtien)));
                  session.save(cthd);
                  JOptionPane.showMessageDialog(null, "Gọi món thành công!");
                   
                  session.getTransaction().commit();
          
                      
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                      
                  
                } finally {
                    session.close();
                }
            }
             
             
             

             
             
                public static BigDecimal GetTongTien(String MaHD) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                        BigDecimal giat = (BigDecimal) session.createQuery("SELECT d.tongTien FROM HoaDon d WHERE d.maHd =:name")
                                .setParameter("name", MaHD)
                            .uniqueResult();

                        
                    if (giat != null) {
                    
                        return giat;
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả.");
                        return BigDecimal.ZERO;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return BigDecimal.ZERO;
                } finally {
                    session.close();
                }
            }
    
                
                
                public static void deleteCTHD (String idCTHD) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  
                  //Xóa CTHD
                   session.beginTransaction();
                  Cthd cthd = (Cthd ) session.get (Cthd .class,idCTHD );
                  session.delete(cthd );
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
    
                
                
                public static void updataCTHD (String idCTHD,int sl, BigDecimal thanhtien ) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  
                  //sửa cthd
                   session.beginTransaction();
                  Cthd cthd = (Cthd ) session.get (Cthd .class,idCTHD );
                  cthd.setSl(sl);
                  cthd.setThanhTien(thanhtien);
                  session.update(cthd );
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
                
                
                
             public static void updataThanhToan (String idHD ) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  
                  //sửa cthd
                   session.beginTransaction();
                  HoaDon hd = (HoaDon) session.get (HoaDon .class,idHD);
                  hd.setGhiChu("Chưa thanh toán");
                 
                  session.update(hd);
                    session.getTransaction().commit();
                  
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }   
                
}
