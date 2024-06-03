/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model_Hiber.BanAn;
import Model_Hiber.Cthd;
import Model_Hiber.DatBan;
import Model_Hiber.Duockhuyenmai;
import Model_Hiber.HoaDon;
import Model_Hiber.KhachHang;
import Model_Hiber.Loai;
import Model_Hiber.Monan;
import Utilities.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static javassist.CtMethod.ConstParameter.string;
import javax.persistence.ParameterMode;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

/**
 *
 * @author admin
 */
public class dal_Menu {
    
    
     
        public static List<Monan> getIDAllMenu(String Loai) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                   List<Monan> LoaiList = session.createQuery("FROM Monan m WHERE m.loai.tenLoai = :tenLoai").setParameter("tenLoai", Loai).list();
                    return LoaiList;
                } catch (Exception e) {
                    return null;
                } finally {
                    session.close();
                }
        }
        
        
            public static List<Monan> getAllMenu() {
                  Session session = HibernateUtil.getSessionFactory().openSession();
                  try {
                      List<Monan> MonanList = session.createQuery("from Monan").list();
                      return MonanList;
                  } catch (Exception e) {
                      return null;
                  } finally {
                      session.close();
                  }
              }
            
            
         
             public static void insertThucDon (String tenmon, BigDecimal Dongia, String hinh, String mota,String tenloai) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                  session.beginTransaction();
                    String giat = (String) session.createQuery("SELECT l.maLoai FROM Loai l WHERE l.tenLoai=:name")
                                .setParameter("name", tenloai)
                            .uniqueResult();

                  
                        
                  
                  
                  Loai  loai = (Loai) session.get (Loai.class,giat );
                  Monan m = new Monan();
                  m.setMaMon("0000");
                  m.setTenMonAn(tenmon);
                  m.setDonGia(Dongia);
                  m.setHinh(hinh);
                  m.setMoTa(mota);
                  m.setLoai(loai);
                  m.setTrangThai("Còn");
                  
                  session.save(m);
                  JOptionPane.showMessageDialog(null, "Thêm món ăn thành công");
                   
                  session.getTransaction().commit();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
            
             
             
            
             
             
              public static void deleteThucDon (String idmon) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                  
                  //Xóa tham chiếu CTHD
                  session.beginTransaction();
                  List<Cthd> listCt = session.createQuery("FROM Cthd  WHERE monan.maMon=:name  ").setParameter("name",  idmon).list();
                   
                  for (Cthd item: listCt)
                  {
                       Monan mmonan = (Monan) session.get (Monan.class,"NULL" );
                        Cthd loai = (Cthd) session.get (Cthd.class,item.getMaCthd() );
                        loai.setMonan(mmonan);
                        session.update(loai);
                  }
                   session.getTransaction().commit();
                  //Xóa tham chiếu KhuyenMai
                   session.beginTransaction();
                  List<Duockhuyenmai> listkm = session.createQuery("FROM Duockhuyenmai  WHERE monan.maMon=:name1  ").setParameter("name1",  idmon).list();
                   
                  for (Duockhuyenmai item: listkm )
                  {
                       Monan mmonan = (Monan) session.get (Monan.class,"NULL" );
                        Duockhuyenmai loai = (Duockhuyenmai) session.get (Duockhuyenmai.class,item.getMaDkm() );
                        loai.setMonan(mmonan);
                        session.update(loai);
                  }
                   session.getTransaction().commit();
                  
                  //Xóa menu
                   session.beginTransaction();
                  Monan mmonan = (Monan) session.get (Monan.class,idmon );
                  session.delete(mmonan);
                    session.getTransaction().commit();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi1: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
             
            
              
         public static void updateThucDon (String idmon,String tenmon, BigDecimal Dongia, String hinh, String mota,String tenloai) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                  session.beginTransaction();
                   String giat = (String) session.createQuery("SELECT l.maLoai FROM Loai l WHERE l.tenLoai=:name")
                                .setParameter("name", tenloai)
                            .uniqueResult();
                   
                   Loai  loai = (Loai) session.get (Loai.class,giat );
                   Monan mmonan = (Monan) session.get (Monan.class,idmon );
                   mmonan.setTenMonAn(tenmon);
                   mmonan.setDonGia(Dongia);
                   mmonan.setHinh(hinh);
                   mmonan.setMoTa(mota);
                   mmonan.setLoai(loai);
                   
                  session.update(mmonan);
                  JOptionPane.showMessageDialog(null, "Sửa món ăn thành công");
                   
                  session.getTransaction().commit();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                } finally {
                    session.close();
                }
            }      
              
             
            
            
        public static double SPKhuyenMai(String mon)
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            try {
                 
                      List<Duockhuyenmai> MonanKMList = session.createQuery("from Duockhuyenmai d WHERE d.monan.tenMonAn=:monann ").setParameter("monann", mon).list();
                    
                      
                      if(!MonanKMList.isEmpty())// có dữ liệu
                      {
                         // JOptionPane.showMessageDialog(null, String.valueOf("vào if"));
                      
                            ProcedureCall procedureCall = session.createStoredProcedureCall("TinhTienGiam");

                            procedureCall.registerParameter("tenmon", String.class, ParameterMode.IN).bindValue(mon);

                            procedureCall.registerParameter("giagiam", Double.class, ParameterMode.OUT);

                            Double giagiam = (Double) procedureCall.getOutputs().getOutputParameterValue("giagiam");

                           return giagiam;
                      }
                      else
                      {
                          return 0.0;
                      }
                  } catch (Exception e) {
                     return 0.0;
                  } finally {
                      session.close();
                  }
        }
        
        
        public static double TinhTien(String mon, int sl)
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            try {
                 
                      List<Duockhuyenmai> MonanKMList = session.createQuery("from Duockhuyenmai d WHERE d.monan.tenMonAn=:monann ").setParameter("monann", mon).list();
                    
                      
                      if(!MonanKMList.isEmpty())// có dữ liệu
                      {
                         // JOptionPane.showMessageDialog(null, String.valueOf("vào if"));
                      
                            ProcedureCall procedureCall = session.createStoredProcedureCall("TinhTien");

                            
                            procedureCall.registerParameter("tenmon", String.class, ParameterMode.IN).bindValue(mon);
                            procedureCall.registerParameter("sluong", Integer.class, ParameterMode.IN).bindValue(sl);
                            procedureCall.registerParameter("giagiam", Double.class, ParameterMode.OUT);

                            Double giagiam = (Double) procedureCall.getOutputs().getOutputParameterValue("giagiam");

                           return giagiam;
                      }
                      else
                      {
                          return 0.0;
                      }
                  } catch (Exception e) {
                     return 0.0;
                  } finally {
                      session.close();
                  }
        }
        
         public static List<Monan> TimKiemMonAn(String mon)
         {
               Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  List<Monan> MonAnList = session.createQuery("FROM Monan m WHERE m.tenMonAn LIKE '%" + mon + "%'").list();
                    return MonAnList;
                } catch (Exception e) {
                    return null;
                } finally {
                    session.close();
                }
             
         }
         
         
             public static BigDecimal GetDuLieuThemMon(String tenmon) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                        BigDecimal giat = (BigDecimal) session.createQuery("SELECT donGia FROM Monan WHERE tenMonAn=:name")
                                .setParameter("name", tenmon)
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
             
             
               public static String getTenLoai(String idMon) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    
                        String giat = (String) session.createQuery("SELECT m.loai.tenLoai FROM Monan m WHERE m.maMon=:name")
                                .setParameter("name", idMon)
                            .uniqueResult();

                  
                        return giat;
                   
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return "null";
                } finally {
                    session.close();
                }
            }
             
               public static Integer GetKhuyenMai (String tenmon) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
          
                      Integer  giat = (Integer) session.createQuery("SELECT k.giam FROM KhuyenMai k, Duockhuyenmai d, Monan m WHERE k.maKm=d.khuyenMai.maKm and d.monan.maMon=m.maMon and m.tenMonAn=:name")
                                .setParameter("name", tenmon)
                            .uniqueResult();

                    if (giat != null) {
                    
                        return giat;
                    } else {
                        return  0;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                      
                        return  0;
                } finally {
                    session.close();
                }
            }
             
             
}
