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
public class ThongKe1 {
      Date ngaytao;
    Double tongtien;
    

    public ThongKe1(Date ngaytao, Double tongtien) {
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
    }

    public ThongKe1() {
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }
  

   
   
}
