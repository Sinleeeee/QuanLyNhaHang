/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.ThongKe;
import Model.ThongKe1;
import Model_Hiber.BanAn;
import Utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class dal_ThongKe {
    
    
     public static List<ThongKe> getThongKe() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("SELECT c.monan.maMon, SUM(c.sl) AS TongSL FROM Cthd c WHERE c.monan.maMon IS NOT NULL GROUP BY c.monan.maMon ORDER BY TongSL DESC");
            query.setMaxResults(3);
            List<Object[]> results = query.list();
            List<ThongKe> thongKeList = new ArrayList<>();
            for (Object[] result : results) {
                String maMon = (String) result[0];
                String tenMon = (String) session.createQuery("SELECT tenMonAn FROM Monan WHERE maMon = :maMon")
                                                .setParameter("maMon", maMon)
                                                .uniqueResult();
                int tongSL = ((Number) result[1]).intValue();
                ThongKe thongKe = new ThongKe(tenMon, tongSL);
                thongKeList.add(thongKe);
            }
            return thongKeList;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
        
        
     }
     
     
     public static List<ThongKe1> getThongKe2() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("SELECT h.ngayTao,SUM(h.tongTien)  FROM HoaDon h GROUP BY h.ngayTao ORDER BY h.ngayTao DESC");
            query.setMaxResults(5);
            List<Object[]> results = query.list();
            List<ThongKe1> thongKeList = new ArrayList<>();
            for (Object[] result : results) {
                Date ngay = (Date) result[0];
                Double tong = ((Number) result[1]).doubleValue();
                ThongKe1 thongKe = new ThongKe1(ngay, tong);
                thongKeList.add(thongKe);
            }
            return thongKeList;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
        
        
     }
    
}
