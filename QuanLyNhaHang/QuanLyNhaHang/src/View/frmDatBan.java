/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAL.dal_BanAn;
import DAL.dal_HoaDon;
import Model.ThongTin_HD;
import Model.TrangThai_Dat;

import Model_Hiber.BanAn;
import Model_Hiber.DatBan;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author admin
 */
public class frmDatBan extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmDatBan
     */
     private frmTrangChu frmTrangChuA;
    
  
    
    public frmDatBan(frmTrangChu frmTC) {
        this.frmTrangChuA = frmTC;
        initComponents();
        loadSoDoBanAn();
        locTrangThai();
      
       //refresh();
      
    }
    
    
    public frmDatBan(int ketqua) {
       
        initComponents();
        loadSoDoBanAn();
        locTrangThai();
       // refresh();
       
      
    }
    
    
//    int KT()
//    {
//        JDesktopPane jp1 =frmTrangChuA.getJDesk1();
//        JDesktopPane jp3 =frmTrangChuA.getJDesk3();
//         JInternalFrame[] frames = jp3.getAllFrames();
//        for (JInternalFrame frame : frames) {
//            if (frame.getTitle().equals("HoaDon")) {
//                frmMenu fm=new frmMenu(this);
//                
//                jp1.add(fm);
//                fm.pack(); 
//                fm.setVisible(true);
//                return 1;
//            }
//            else
//            {
//                return 0;
//            }
//        }
//        return 0;
//    }
    
    
    
    void locTrangThai()
    {
       cbTrangThaiBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String tentrangthai= (String) cbTrangThaiBan.getSelectedItem();
               
                 
                  List<BanAn> BanAnList = dal_BanAn.locTrangThai(tentrangthai);
                  
                panelDatBan.removeAll();
                panelDatBan.revalidate();
                panelDatBan.repaint();
                  int x=10;
          int y=5;
          int flag=1;
          for(BanAn item:BanAnList)
          {
              JButton btn = new JButton();
              btn.setBounds(x, y, 70, 100);
              btn.setSize(80, 50); 
              btn.setText(item.getTenBan());
              
              //set màu trạng thái
              int color = dal_BanAn.setColorTrangThaiBan(item.getTenBan());
              if(color ==1)
              {
                  btn.setBackground(Color.GREEN);
              }
              else if(color==2)
              {
                   btn.setBackground(Color.RED);
              }
              else
              {
                  btn.setBackground(Color.YELLOW);
                 
              }
              //set form khi click
              btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JDesktopPane jp3 =frmTrangChuA.getJDesk3();
                         jp3.removeAll(); 
                     String tenban = btn.getText();
                     int color = dal_BanAn.setColorTrangThaiBan(tenban);
    
                     if(color ==2)// thông tin khách hàng đặt bàn ==> màu đỏ
                     {
                       
                      
                         frmNone frmN = new frmNone();
                         jp3.add(frmN);
                         frmN.pack(); 
                         frmN.setVisible(true);
             
                         List<TrangThai_Dat> thongtinkhachdat=dal_BanAn.loadthongtin(tenban);
                         if(!thongtinkhachdat.isEmpty())
                
                         {
                         for (TrangThai_Dat item: thongtinkhachdat)
                    
                          { 
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                             String dateString = formatter.format(item.getNgayDat());
                             frmTrangThai_Dat frm5 = new frmTrangThai_Dat(item.getTenKH(),item.getSDT(),item.getSoLuong(),dateString,item.getMaDB(),tenban,frmDatBan.this );
                            
                            frm5.setVisible(true);
                           
                       
                                
                         }
                         // loadSoDoBanAn();
                         }
                         
                        
                     }
                     else if(color ==1)
                     {
                         
                            jp3 =frmTrangChuA.getJDesk3();
                            List<ThongTin_HD> thongtin=dal_HoaDon.loadthongtinHD(tenban);
                         
                            for (ThongTin_HD item : thongtin)
                            {
                                 frmHoaDon frmHD = new frmHoaDon(item.getTenban(),item.getMaHD(),item.getTenKH(),item.getSDT(),item.getTongtien(),frmTrangChuA,item.getMadb());
                            
                                 jp3.add(frmHD);
                           frmHD.pack(); 
                           frmHD.setVisible(true);
                           
                          
                            }
                          
                           
                     }
                     else 
                     {
                         //Destop Left
                         jp3 =frmTrangChuA.getJDesk3();
                        
                         frmNone frmN = new frmNone();
                         jp3.add(frmN);
                         frmN.pack(); 
                         frmN.setVisible(true);
                         
                         //
                       
                         frmKhachHang frmKh=new frmKhachHang(frmDatBan.this,item.getMaBan());
                         frmKh.pack(); 
                         frmKh.setVisible(true);
                     }
                     
                  }
              });
              
              
              
              
               if(flag%3==0)
                {
                    x=10;
                    y=y+60;
                }
                else
                {
                    x+=92;
                   
                }
               
               flag++;
              
               panelDatBan.add(btn);
               
          }
                 
                 
           }
     });
 
    }

     void loadSoDoBanAn()
    { panelDatBan.removeAll();    
                panelDatBan.revalidate(); 
                panelDatBan.repaint(); 
          List<BanAn> BanAnList = dal_BanAn.TenBanAn();
          
          int x=10;
          int y=5;
          int flag=1;
          for(BanAn item:BanAnList)
          {
              JButton btn = new JButton();
              btn.setBounds(x, y, 70, 100);
              btn.setSize(80, 50); 
              btn.setText(item.getTenBan());
              
              //set màu trạng thái
              int color = dal_BanAn.setColorTrangThaiBan(item.getTenBan());
              if(color ==1)
              {
                  btn.setBackground(Color.GREEN);
              }
              else if(color==2)
              {
                   btn.setBackground(Color.RED);
              }
              else
              {
                  btn.setBackground(Color.YELLOW);
                 
              }
              //set form khi click
              btn.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        JDesktopPane jp3 =frmTrangChuA.getJDesk3();
                         jp3.removeAll(); 
                     String tenban = btn.getText();
                     int color = dal_BanAn.setColorTrangThaiBan(tenban);
    
                     if(color ==2)// thông tin khách hàng đặt bàn ==> màu đỏ
                     {
                       
                      
                         frmNone frmN = new frmNone();
                         jp3.add(frmN);
                         frmN.pack(); 
                         frmN.setVisible(true);
             
                         List<TrangThai_Dat> thongtinkhachdat=dal_BanAn.loadthongtin(tenban);
                         if(!thongtinkhachdat.isEmpty())
                
                         {
                         for (TrangThai_Dat item: thongtinkhachdat)
                    
                          { 
                                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                             String dateString = formatter.format(item.getNgayDat());
                             frmTrangThai_Dat frm5 = new frmTrangThai_Dat(item.getTenKH(),item.getSDT(),item.getSoLuong(),dateString,item.getMaDB(),tenban,frmDatBan.this);
                            
                            frm5.setVisible(true);
                           
                       
                                
                         }
                         // loadSoDoBanAn();
                         }
                         
                        
                     }
                     else if(color ==1)
                     {
                         
                            jp3 =frmTrangChuA.getJDesk3();
                            List<ThongTin_HD> thongtin=dal_HoaDon.loadthongtinHD(tenban);
                         
                            for (ThongTin_HD item : thongtin)
                            {
                                 frmHoaDon frmHD = new frmHoaDon(item.getTenban(),item.getMaHD(),item.getTenKH(),item.getSDT(),item.getTongtien(),frmTrangChuA,item.getMadb());
                            
                                 jp3.add(frmHD);
                           frmHD.pack(); 
                           frmHD.setVisible(true);
                           
                          
                            }
                          
                           
                     }
                     else 
                     {
                         //Destop Left
                         jp3 =frmTrangChuA.getJDesk3();
                        
                         frmNone frmN = new frmNone();
                         jp3.add(frmN);
                         frmN.pack(); 
                         frmN.setVisible(true);
                         
                         //
                       
                         frmKhachHang frmKh=new frmKhachHang(frmDatBan.this,item.getMaBan());
                         frmKh.pack(); 
                         frmKh.setVisible(true);
                     }
                     
                  }
              });
              
              
              
              
               if(flag%3==0)
                {
                    x=10;
                    y=y+60;
                }
                else
                {
                    x+=92;
                   
                }
               
               flag++;
              
               panelDatBan.add(btn);
               
          }
           
    }
    
//public int refresh() {
//    Timer timer = new Timer(1000, new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int result = KT();
//            if (result == 1) {
//                ((Timer) e.getSource()).stop();
//                return;
//            }
//        }
//    });
//    timer.start(); 
//    return 0;
//}
    
  
  
  public void HienthiHD(String tenban)
  {
       JDesktopPane jp3 =frmTrangChuA.getJDesk3();
                            List<ThongTin_HD> thongtin=dal_HoaDon.loadthongtinHD(tenban);
                            for (ThongTin_HD item : thongtin)
                            {
                                 frmHoaDon frmHD = new frmHoaDon(item.getTenban(),item.getMaHD(),item.getTenKH(),item.getSDT(),item.getTongtien(),frmTrangChuA,item.getMadb());
                            jp3.add(frmHD);
                           frmHD.pack(); 
                           frmHD.setVisible(true);
                            }
                          
  }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelDatBan = new javax.swing.JPanel();
        cbTrangThaiBan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(255, 154, 60));
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(21, 82, 99));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thông Tin Bàn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hoạt động");

        jPanel6.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trống");

        jPanel7.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Đã đặt");

        panelDatBan.setBackground(new java.awt.Color(255, 154, 60));

        javax.swing.GroupLayout panelDatBanLayout = new javax.swing.GroupLayout(panelDatBan);
        panelDatBan.setLayout(panelDatBanLayout);
        panelDatBanLayout.setHorizontalGroup(
            panelDatBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        panelDatBanLayout.setVerticalGroup(
            panelDatBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );

        cbTrangThaiBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Hoạt động", "Trống", "Đã đặt" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Trạng thái bàn:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Khác"));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/597007__1_-removebg-preview.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(21, 82, 99));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chuyển bàn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/tải xuống (1).png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(21, 82, 99));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ghép bàn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(panelDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbTrangThaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbTrangThaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(375, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        frmChuyenBan frmChange = new frmChuyenBan(this);
        frmChange .pack();
       frmChange.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          frmGhepBan frmGhep = new frmGhepBan(this);
          frmGhep.pack();
          frmGhep.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbTrangThaiBan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel panelDatBan;
    // End of variables declaration//GEN-END:variables
}
