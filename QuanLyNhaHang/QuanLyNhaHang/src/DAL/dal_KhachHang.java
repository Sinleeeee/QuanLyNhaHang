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
import Model_Hiber.Monan;
import Model_Hiber.NhanVien;
import Utilities.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.ParameterMode;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

/**
 *
 * @author admin
 */
public class dal_KhachHang {
    
    
    public static void insertKhachHang (String tenKH, String sdt, String id) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  session.beginTransaction();
                  KhachHang kh = new  KhachHang();
                  kh.setTenKh(tenKH);
                  kh.setSdt(sdt);
                  kh.setMaKh(id);
     
                  session.save(kh);
                  JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
                   
                  session.getTransaction().commit();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
    
    
    public static void insertDatBan (Date TGVao, String slkhach, String trangthai, String idban, String maKH) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                  session.beginTransaction();
                  
                   
                   KhachHang  khachhang = (KhachHang) session.get (KhachHang.class,maKH );
                   BanAn banan= (BanAn) session.get(BanAn.class,idban);
                  DatBan db= new  DatBan();
                  db.setMaDatBan("0000");
                  db.setSlkhach(Integer.parseInt(slkhach));
                  db.setThoiGianVao(TGVao);
                  db.setTrangThai(trangthai);
                  db.setBanAn(banan);
                  db.setKhachHang(khachhang);
     
                  session.save(db);
                  JOptionPane.showMessageDialog(null, "Đặt bàn thành công");
                   
                  session.getTransaction().commit();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
                } finally {
                    session.close();
                }
            }
    
    
       public static String getMaKH()
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            try {
                 
                   
                    
                      
                    
                      
                            ProcedureCall procedureCall = session.createStoredProcedureCall("KhachHangID_auto");

                            
                      
                            procedureCall.registerParameter("MaKH", String.class, ParameterMode.OUT);

                            String ID = (String) procedureCall.getOutputs().getOutputParameterValue("MaKH");

                           return ID;
                      
                     
                  } catch (Exception e) {
                        String aa= "null";
                    return aa;
                  } finally {
                      session.close();
                  }
        }
        
    
}
