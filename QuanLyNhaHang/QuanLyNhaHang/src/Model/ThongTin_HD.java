/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author admin
 */
public class ThongTin_HD {
    
    String tenban;
    String maHD;
    String tenKH;
    String SDT;
    BigDecimal tongtien;
    String madb;

    public ThongTin_HD(String tenban, String maHD, String tenKH, String SDT, BigDecimal tongtien, String madb) {
        this.tenban = tenban;
        this.maHD = maHD;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.tongtien = tongtien;
        this.madb = madb;
    }

    public ThongTin_HD() {
    }

    public String getTenban() {
        return tenban;
    }

    public void setTenban(String tenban) {
        this.tenban = tenban;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public String getMadb() {
        return madb;
    }

    public void setMadb(String madb) {
        this.madb = madb;
    }


    
   


    
         
    
}
