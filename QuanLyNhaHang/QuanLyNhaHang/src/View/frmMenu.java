/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAL.dal_Loai;
import DAL.dal_Menu;
import Model_Hiber.Loai;
import Model_Hiber.Monan;

import Utilities.HibernateUtil;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import static javafx.scene.paint.Color.rgb;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author admin
 */
public class frmMenu extends javax.swing.JInternalFrame {

    frmTrangChu frmTC;

    /**
     * Creates new form frmMenu
     */
    frmDatBan frmDB;
    public frmMenu() {
        
        initComponents();
        loadbtnMenu();
        loadMenu();
        
        //  this.add(jPanel1);
      //loadMenu();
       
    }
    
//     public frmMenu(frmDatBan frmDB) {
//        
//        initComponents();
//        this.frmDB=frmDB;
//        loadbtnMenu();
//        loadMenu();
//        
//        //  this.add(jPanel1);
//      //loadMenu();
//       
//    }
     
      public frmMenu(frmTrangChu frmTC) {
        
        initComponents();
        this.frmTC=frmTC;
        loadbtnMenu();
        loadMenu();
        
        //  this.add(jPanel1);
      //loadMenu();
       
    }
    

public void loadbtnMenu() {
    List<Loai> LoaiList = dal_Loai.getAllLoai();
    cbTenLoai.addItem("Tất cả");
    for (Loai Loai : LoaiList) {
        cbTenLoai.addItem(Loai.getTenLoai());
        cbTenLoai.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String tenloai= (String) cbTenLoai.getSelectedItem();
               jPanel1.removeAll();
                jPanel1.revalidate();
                jPanel1.repaint();
               if(tenloai !="Tất cả")
               {
                loadMenuID(tenloai);
               }
               else
               {
                   loadMenu();
               }
            }
        });
    }
    
    

    
}


public void loadMenuID(String tenloai)
{
   List<Monan> MonAnList = dal_Menu.getIDAllMenu(tenloai);
   
     int x=15;
       int y=10, flag=1;
        for (Monan item : MonAnList) 
        {
           
            //tạo khung
               JPanel khung = new JPanel();
         
               khung.setBounds(x, y, 150, 200);
               Color mauNen = new Color(255, 201, 60);
               khung.setBackground(mauNen);
         
                if(flag%4==0)
                {
                    x=15;
                    y=y+210;
                }
                else
                {
                    x+=165;
                   
                }
             // thêm ảnh
      
           ImageIcon icon = new ImageIcon(getClass().getResource("/Picture/" + item.getHinh()));
            Image image = icon.getImage().getScaledInstance(130, 120, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);
                     khung.add( label);
            //Tên món
            JLabel tenmon = new JLabel();
            tenmon.setText(item.getTenMonAn()+"\n");
            tenmon.setFont(new Font("Arial", Font.BOLD, 12));
            Color mauNenchu = new Color(38, 58, 41);
            tenmon.setForeground(mauNenchu);
           khung.add(tenmon);
           
           
 
           
                //Mô tả
            JLabel mota = new JLabel();
            if (item.getMoTa().length()<10)
            {
                   mota.setText(item.getMoTa());
            }
            else
            {
               mota.setText(item.getMoTa().substring(0,10));
            }


             Color mauNenchu1 = new Color(149, 189, 255);
             mota.setForeground(mauNenchu1);
             mota.setHorizontalAlignment(JLabel.LEFT);
            khung.add(mota);

            
          
            if(dal_Menu.SPKhuyenMai(item.getTenMonAn())!=0.0)
            {
                //Giá nguyên gốc
                double s= dal_Menu.SPKhuyenMai(item.getTenMonAn());
                JLabel giatien = new JLabel();
                NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                BigDecimal dongia=item.getDonGia();
                String chuyen = formatter.format(dongia);
                
                Map<TextAttribute, Object> attributes = new HashMap<>();
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                Font font1 = new Font("Arial", Font.BOLD, 15).deriveFont(attributes);
               
                giatien.setText(chuyen);
                giatien.setFont(font1);
                 Color mauNengia = new Color(78, 110, 129);
                giatien.setForeground(mauNengia);
                khung.add(giatien);
                //Giá sau khi giảm:
                
                 JLabel giatien1 = new JLabel();
                   
                    Double gia= dal_Menu.SPKhuyenMai(item.getTenMonAn());
                    String chuyen1 = formatter.format(gia);

                    giatien1.setText(chuyen1);
                     Color mauNengia1 = new Color(214, 19, 85);
                    giatien1.setForeground(mauNengia1);
                    giatien1.setFont(new Font("Arial", Font.BOLD, 15));
                    khung.add(giatien1);
               
                
               
           
               
            }
            else
            {
                        JLabel giatien = new JLabel();
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                    BigDecimal dongia=item.getDonGia();
                    String chuyen = formatter.format(dongia);

                    giatien.setText(chuyen);
                     Color mauNengia = new Color(214, 19, 85);
                    giatien.setForeground(mauNengia);
                    giatien.setFont(new Font("Arial", Font.BOLD, 15));
                    khung.add(giatien);
            }
            
                
            //Khi hover thì đổi màu
            khung.addMouseListener(new MouseAdapter() {
                
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Color mauNenexit = new Color(255, 111, 60);
                    khung.setBackground(mauNenexit);
                }

                    @Override
                public void mouseExited(MouseEvent e) {
                    
                    khung.setBackground(mauNen);
                }

                
            });
            
            //Khi click thì hiện form thêm món
           khung.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String ten = null;
                   JDesktopPane jp3 = frmTC.getJDesk3();
                    JInternalFrame[] frames = jp3.getAllFrames();
                    
                    for (JInternalFrame frame : frames) {
                        if (frame.getTitle().equals("HoaDon")) {
                         frmGoiMon frmGm = new frmGoiMon(frmHoaDon.MaHD_ST, frmHoaDon.TenBan_ST,item.getTenMonAn(),item.getHinh());
                  
                          frmGm.setVisible(true);
                          break;
                        }
                    }
    
        
                }
            });
            
            
            
               
               
             jPanel1.add(khung);
             flag+=1;


        }
    

 

    
   
}
 public  void loadMenu()
  {
       List<Monan> MonAnList = dal_Menu.getAllMenu();
    
       
       int x=15;
       int y=10, flag=1;
        for (Monan item : MonAnList) 
        {
           
            //tạo khung
               JPanel khung = new JPanel();
         
               khung.setBounds(x, y, 150, 200);
               Color mauNen = new Color(255, 201, 60);
               khung.setBackground(mauNen);
         
                if(flag%4==0)
                {
                    x=15;
                    y=y+210;
                }
                else
                {
                    x+=165;
                   
                }
             // thêm ảnh
      
           ImageIcon icon = new ImageIcon(getClass().getResource("/Picture/" + item.getHinh()));
            Image image = icon.getImage().getScaledInstance(130, 120, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);
                     khung.add( label);
            //Tên món
            JLabel tenmon = new JLabel();
            tenmon.setText(item.getTenMonAn()+"\n");
            tenmon.setFont(new Font("Arial", Font.BOLD, 12));
            Color mauNenchu = new Color(38, 58, 41);
            tenmon.setForeground(mauNenchu);
           khung.add(tenmon);
           
           
 
           
                //Mô tả
            JLabel mota = new JLabel();
            if (item.getMoTa().length()<10)
            {
                   mota.setText(item.getMoTa());
            }
            else
            {
               mota.setText(item.getMoTa().substring(0,10));
            }


             Color mauNenchu1 = new Color(149, 189, 255);
             mota.setForeground(mauNenchu1);
             mota.setHorizontalAlignment(JLabel.LEFT);
            khung.add(mota);

            
          
            if(dal_Menu.SPKhuyenMai(item.getTenMonAn())!=0.0)
            {
                //Giá nguyên gốc
                double s= dal_Menu.SPKhuyenMai(item.getTenMonAn());
                JLabel giatien = new JLabel();
                NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                BigDecimal dongia=item.getDonGia();
                String chuyen = formatter.format(dongia);
                
                Map<TextAttribute, Object> attributes = new HashMap<>();
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                Font font1 = new Font("Arial", Font.BOLD, 15).deriveFont(attributes);
               
                giatien.setText(chuyen);
                giatien.setFont(font1);
                 Color mauNengia = new Color(78, 110, 129);
                giatien.setForeground(mauNengia);
                khung.add(giatien);
                //Giá sau khi giảm:
                
                 JLabel giatien1 = new JLabel();
                   
                    Double gia= dal_Menu.SPKhuyenMai(item.getTenMonAn());
                    String chuyen1 = formatter.format(gia);

                    giatien1.setText(chuyen1);
                     Color mauNengia1 = new Color(214, 19, 85);
                    giatien1.setForeground(mauNengia1);
                    giatien1.setFont(new Font("Arial", Font.BOLD, 15));
                    khung.add(giatien1);
               
                
               
           
               
            }
            else
            {
                        JLabel giatien = new JLabel();
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                    BigDecimal dongia=item.getDonGia();
                    String chuyen = formatter.format(dongia);

                    giatien.setText(chuyen);
                     Color mauNengia = new Color(214, 19, 85);
                    giatien.setForeground(mauNengia);
                    giatien.setFont(new Font("Arial", Font.BOLD, 15));
                    khung.add(giatien);
            }
            
                
            //Khi hover thì đổi màu
            khung.addMouseListener(new MouseAdapter() {
                
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Color mauNenexit = new Color(255, 111, 60);
                    khung.setBackground(mauNenexit);
                }

                    @Override
                public void mouseExited(MouseEvent e) {
                    
                    khung.setBackground(mauNen);
                }

                
            });
            
            //Khi click thì hiện form thêm món
           khung.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String ten = null;
                   JDesktopPane jp3 = frmTC.getJDesk3();
                    JInternalFrame[] frames = jp3.getAllFrames();
                    
                    for (JInternalFrame frame : frames) {
                        if (frame.getTitle().equals("HoaDon")) {
                         frmGoiMon frmGm = new frmGoiMon(frmHoaDon.MaHD_ST, frmHoaDon.TenBan_ST,item.getTenMonAn(),item.getHinh());
                  
                          frmGm.setVisible(true);
                          break;
                        }
                    }
    
        
                }
            });
            
            
            
               
               
             jPanel1.add(khung);
             flag+=1;


        }
    

 

  }
    
//public void actionJmenu(MenuEvent e) {
//    JMenu menu = (JMenu) e.getSource();
//    String tenLoai = menu.getText();
//    JOptionPane.showMessageDialog(null, "giá trị là: " + tenLoai );
//    List<Monan> MonAnList = dal_Menu.getIDAllMenu(tenLoai);
//    JOptionPane.showMessageDialog(null, "giá trị là:ghjgjh " + tenLoai );
//
//    JPanel container = new JPanel(); // Tạo container chứa các JButton
//    for (Monan item : MonAnList) {
//        JOptionPane.showMessageDialog(null, "gi265 " );
//        JOptionPane.showMessageDialog(null, "*** là: " + item.getTenMonAn()+item.getTrangThai());
//        JButton menuButton = new JButton();
//        ImageIcon imageIcon = new ImageIcon(item.getHinh());
//        menuButton.setIcon(imageIcon);
//        menuButton.setText(item.getTenMonAn());
//        menuButton.setToolTipText(item.getMoTa());
//        menuButton.setPreferredSize(new Dimension(20, 20));
//        jPanel1.add(menuButton); // Thêm JButton vào container
//    }
//
//   this.add(jPanel1); // Thêm container vào JFrame
//    //this.pack(); // Để JFrame tự động điều chỉnh kích thước phù hợp với nội dung container
//    this.setVisible(true);
//}
//    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cbTenLoai = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 255, 102));

        jPanel2.setBackground(new java.awt.Color(255, 201, 60));

        cbTenLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenLoaiActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(21, 82, 99));
        btnTimKiem.setText("Tìm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 600));

        jPanel1.setBackground(new java.awt.Color(21, 82, 99));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String timkiem = txtTimKiem.getText();
         List<Monan> MonAnList = dal_Menu.TimKiemMonAn(timkiem);
         if(!MonAnList.isEmpty())
         {
             jPanel1.removeAll();
                jPanel1.revalidate();
                jPanel1.repaint();
              int x=15;
       int y=10, flag=1;
        for (Monan item : MonAnList) 
        {
           
            //tạo khung
               JPanel khung = new JPanel();
         
               khung.setBounds(x, y, 150, 200);
               Color mauNen = new Color(255, 201, 60);
               khung.setBackground(mauNen);
         
                if(flag%4==0)
                {
                    x=15;
                    y=y+210;
                }
                else
                {
                    x+=165;
                   
                }
             // thêm ảnh
      
           ImageIcon icon = new ImageIcon(getClass().getResource("/Picture/" + item.getHinh()));
            Image image = icon.getImage().getScaledInstance(130, 120, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);
                     khung.add( label);
            //Tên món
            JLabel tenmon = new JLabel();
            tenmon.setText(item.getTenMonAn()+"\n");
            tenmon.setFont(new Font("Arial", Font.BOLD, 12));
            Color mauNenchu = new Color(38, 58, 41);
            tenmon.setForeground(mauNenchu);
           khung.add(tenmon);
           
           
 
           
                //Mô tả
            JLabel mota = new JLabel();
            if (item.getMoTa().length()<10)
            {
                   mota.setText(item.getMoTa());
            }
            else
            {
               mota.setText(item.getMoTa().substring(0,10));
            }


             Color mauNenchu1 = new Color(149, 189, 255);
             mota.setForeground(mauNenchu1);
             mota.setHorizontalAlignment(JLabel.LEFT);
            khung.add(mota);

            
          
            if(dal_Menu.SPKhuyenMai(item.getTenMonAn())!=0.0)
            {
                //Giá nguyên gốc
                double s= dal_Menu.SPKhuyenMai(item.getTenMonAn());
                JLabel giatien = new JLabel();
                NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                BigDecimal dongia=item.getDonGia();
                String chuyen = formatter.format(dongia);
                
                Map<TextAttribute, Object> attributes = new HashMap<>();
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                Font font1 = new Font("Arial", Font.BOLD, 15).deriveFont(attributes);
               
                giatien.setText(chuyen);
                giatien.setFont(font1);
                 Color mauNengia = new Color(78, 110, 129);
                giatien.setForeground(mauNengia);
                khung.add(giatien);
                //Giá sau khi giảm:
                
                 JLabel giatien1 = new JLabel();
                   
                    Double gia= dal_Menu.SPKhuyenMai(item.getTenMonAn());
                    String chuyen1 = formatter.format(gia);

                    giatien1.setText(chuyen1);
                     Color mauNengia1 = new Color(214, 19, 85);
                    giatien1.setForeground(mauNengia1);
                    giatien1.setFont(new Font("Arial", Font.BOLD, 15));
                    khung.add(giatien1);
               
                
               
           
               
            }
            else
            {
                        JLabel giatien = new JLabel();
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                    BigDecimal dongia=item.getDonGia();
                    String chuyen = formatter.format(dongia);

                    giatien.setText(chuyen);
                     Color mauNengia = new Color(214, 19, 85);
                    giatien.setForeground(mauNengia);
                    giatien.setFont(new Font("Arial", Font.BOLD, 15));
                    khung.add(giatien);
            }
            
                
            //Khi hover thì đổi màu
            khung.addMouseListener(new MouseAdapter() {
                
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Color mauNenexit = new Color(255, 111, 60);
                    khung.setBackground(mauNenexit);
                }

                    @Override
                public void mouseExited(MouseEvent e) {
                    
                    khung.setBackground(mauNen);
                }

                
            });
            
            //Khi click thì hiện form thêm món
           khung.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String ten = null;
                   JDesktopPane jp3 = frmTC.getJDesk3();
                    JInternalFrame[] frames = jp3.getAllFrames();
                    
                    for (JInternalFrame frame : frames) {
                        if (frame.getTitle().equals("HoaDon")) {
                         frmGoiMon frmGm = new frmGoiMon(frmHoaDon.MaHD_ST, frmHoaDon.TenBan_ST,item.getTenMonAn(),item.getHinh());
                  
                          frmGm.setVisible(true);
                          break;
                        }
                    }
    
        
                }
            });
            
            
            
               
               
             jPanel1.add(khung);
             flag+=1;


        }
    

 

         }
         else
         {
             JOptionPane.showMessageDialog(null, "Không tìm thấy món ăn cần tìm");
              jPanel1.removeAll();
                jPanel1.revalidate();
                jPanel1.repaint();
                loadMenu();
         }
        
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbTenLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTenLoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbTenLoai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
