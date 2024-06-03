/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model_Hiber.Loai;
import Utilities.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class dal_Loai {
    
      public static List<Loai> getAllLoai() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Loai> LoaiList = session.createQuery("from Loai").list();
            return LoaiList;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }
    
}
