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
public class PhanQuyenNV {
    
    static String idNV;
    static String tenNV;
    static String sdt;

    public PhanQuyenNV(String idNV,String tenNV,String sdt) {
        this.idNV=idNV;
        this.tenNV=tenNV;
        this.sdt=sdt;
    }

    public static String getIdNV() {
        return idNV;
    }

    public static void setIdNV(String idNV) {
        PhanQuyenNV.idNV = idNV;
    }

    public static String getTenNV() {
        return tenNV;
    }

    public static void setTenNV(String tenNV) {
        PhanQuyenNV.tenNV = tenNV;
    }

    public static String getSdt() {
        return sdt;
    }

    public static void setSdt(String sdt) {
        PhanQuyenNV.sdt = sdt;
    }
    
    
    
    
}
