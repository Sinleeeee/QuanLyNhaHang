/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class TrangThai_Dat {
    String TenKH;
    String SDT;
    int SoLuong;
    Date NgayDat;
    String maDB;
    
    public TrangThai_Dat(String TenKH, String SDT, int SoLuong, Date NgayDat, String maDB) {
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.SoLuong = SoLuong;
        this.NgayDat = NgayDat;
        this.maDB = maDB;
    }

    public TrangThai_Dat() {
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public String getMaDB() {
        return maDB;
    }

    public void setMaDB(String maDB) {
        this.maDB = maDB;
    }

    
  

  

    
    
}
