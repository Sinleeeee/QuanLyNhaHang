/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.PhanQuyenNV;
import Model_Hiber.Chitiethoadonnhap;
import Model_Hiber.DangNhap;
import Model_Hiber.HoaDon;
import Model_Hiber.Hoadonnhap;
import Model_Hiber.Nguyenlieu;
import Model_Hiber.NhanVien;
import Utilities.HibernateUtil;
import static java.lang.String.format;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

/**
 *
 * @author admin
 */
public class dal_NhapHang {
    
      public  static List<Object[]> loadthongtinHDN ()
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<Object[]> resultList  = session.createQuery("SELECT h.maHdn, h.ngayTao,h.ghiChu,h.tongTien FROM Hoadonnhap h ORDER BY  h.ghiChu ASC ").list();

                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
      
      
        public  static List<Object[]> loadthongtinCTHDN ( String maHDN)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<Object[]> resultList  = session.createQuery("SELECT c.maCthdn, v.tenNl,n.tenNcc,v.donVi,c.sl,c.donGia,c.thanhTien FROM Chitiethoadonnhap c, Nhacungcap n, Nguyenlieu v WHERE n.maNcc=v.nhacungcap.maNcc AND v.maNl =c.nguyenlieu.maNl AND c.hoadonnhap.maHdn=:name ")
                         .setParameter("name", maHDN)
                         .list();

                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
        
            public  static void delCTHDN ( String maCTHD)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                 session.beginTransaction();
                    
                    Chitiethoadonnhap cthdn =(Chitiethoadonnhap) session.get (Chitiethoadonnhap.class,maCTHD);
                   
                    session.delete(cthdn);
                                session.getTransaction().commit();            
                 

                
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
         
                } finally {
                    session.close();
                }
    }
            
            
            public  static void updateCTHDN ( int SL, BigDecimal thanhtien, String maCTHD)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                 session.beginTransaction();
                    
                    Chitiethoadonnhap cthdn =(Chitiethoadonnhap) session.get (Chitiethoadonnhap.class,maCTHD);
                   cthdn.setSl(SL);
                   cthdn.setThanhTien(thanhtien);
                    session.update(cthdn);
                                session.getTransaction().commit();            
                 

                
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
         
                } finally {
                    session.close();
                }
    }
            
            
            
    public  static void insertHDN ()
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                // JOptionPane.showMessageDialog(null, PhanQuyenNV.getIdNV());
                     NhanVien  nv = (NhanVien) session.get (NhanVien.class,PhanQuyenNV.getIdNV() );
                    
                       session.beginTransaction();
                     Hoadonnhap hdn = new Hoadonnhap();
             
                     hdn.setMaHdn("00000");
                   Date currentDate = new Date(); 
                    hdn.setNgayTao(currentDate);
                    
                    hdn.setGhiChu("Chưa thanh toán");
                  
                    hdn.setTongTien(BigDecimal.ZERO);
                    
                    hdn.setNhanVien(nv);
                   
                    session.save(hdn);
                  
                    session.getTransaction().commit(); 
                  
                 JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn nhập thành công");

                
                } catch (Exception e) {
                      System.out.println(e.getMessage());
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                      
                } finally {
                    session.close();
                }
    }
            
            
             public  static void insertCTHDN ( String maHDN, String tenNL, BigDecimal thanhtien, int SL, BigDecimal dongia  )
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    // get manl
                    String manl  = (String)session.createQuery("SELECT n.maNl FROM Nguyenlieu n WHERE n.tenNl=:name")
                         .setParameter("name", tenNL)
                         .uniqueResult();
                    
                    //lấy IDCTHDN
                     ProcedureCall procedureCall = session.createStoredProcedureCall("IDCTHDN_Auto");
                   procedureCall.registerParameter("MaCTHDN", String.class, ParameterMode.OUT);

                    String idCTHDNnew = (String) procedureCall.getOutputs().getOutputParameterValue("MaCTHDN");
                    
                    //thêm
                    // JOptionPane.showMessageDialog(null, "Mã new: "+ idCTHDNnew );
                    
                     Nguyenlieu  nl = (Nguyenlieu) session.get (Nguyenlieu.class,manl );
                     Hoadonnhap hdn =(Hoadonnhap) session.get (Hoadonnhap.class,maHDN );
                     session.beginTransaction();
                    Chitiethoadonnhap cthdn = new Chitiethoadonnhap();
                    cthdn.setMaCthdn(idCTHDNnew);
                    cthdn.setDonGia(dongia);
                    cthdn.setSl(SL);
                    cthdn.setThanhTien(thanhtien);
                    cthdn.setNguyenlieu(nl);
                    cthdn.setHoadonnhap(hdn);
                    
                    session.save(cthdn);
                                session.getTransaction().commit();            
                 JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn nhập thành công");

                
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
         
                } finally {
                    session.close();
                }
    }
        
        
              public  static List<Nguyenlieu> loadNguyenLieu ()
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<Nguyenlieu> resultList  = session.createQuery("FROM Nguyenlieu").list();

                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
              
              
              
     public  static List<Nguyenlieu> loadNguyenLieu_Name (String tennl)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 List<Nguyenlieu> resultList  = session.createQuery("FROM Nguyenlieu n WHERE n.tenNl=:name")
                         .setParameter("name", tennl)
                         .list();

                  return resultList;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
     
     
      public  static String loadTenNCC (String tennl)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                                            
                 String tenncc  = (String)session.createQuery("SELECT n.nhacungcap.tenNcc FROM Nguyenlieu n WHERE n.tenNl=:name")
                         .setParameter("name", tennl)
                         .uniqueResult();

                  return tenncc;
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                    return null;
                } finally {
                    session.close();
                }
    }
    
}
