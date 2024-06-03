/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class ThongKe {
    
    
   String maSP;
   int SL;

    public ThongKe(String maSP, int SL) {
        this.maSP = maSP;
        this.SL = SL;
    }

    public ThongKe() {
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }
    
    
   
    
}
