package Model_Hiber;
// Generated Apr 19, 2023 8:08:57 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * DatBan generated by hbm2java
 */
@Entity
@Table(name="DatBan"
    ,schema="dbo"
    ,catalog="QUANLYNHAHANG_JAVA_D12"
    , uniqueConstraints = @UniqueConstraint(columnNames={"MaBan", "MaKH"}) 
)
public class DatBan  implements java.io.Serializable {


     private String maDatBan;
     private BanAn banAn;
     private KhachHang khachHang;
     private Date thoiGianVao;
     private int slkhach;
     private String trangThai;

    public DatBan() {
    }

    public DatBan(String maDatBan, BanAn banAn, KhachHang khachHang, Date thoiGianVao, int slkhach, String trangThai) {
       this.maDatBan = maDatBan;
       this.banAn = banAn;
       this.khachHang = khachHang;
       this.thoiGianVao = thoiGianVao;
       this.slkhach = slkhach;
       this.trangThai = trangThai;
    }
   
     @Id 

    
    @Column(name="MaDatBan", unique=true, nullable=false, length=5)
    public String getMaDatBan() {
        return this.maDatBan;
    }
    
    public void setMaDatBan(String maDatBan) {
        this.maDatBan = maDatBan;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MaBan", nullable=false)
    public BanAn getBanAn() {
        return this.banAn;
    }
    
    public void setBanAn(BanAn banAn) {
        this.banAn = banAn;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MaKH", nullable=false)
    public KhachHang getKhachHang() {
        return this.khachHang;
    }
    
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ThoiGianVao", nullable=false, length=10)
    public Date getThoiGianVao() {
        return this.thoiGianVao;
    }
    
    public void setThoiGianVao(Date thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    
    @Column(name="SLKhach", nullable=false)
    public int getSlkhach() {
        return this.slkhach;
    }
    
    public void setSlkhach(int slkhach) {
        this.slkhach = slkhach;
    }

    
    @Column(name="TrangThai", nullable=false, length=50)
    public String getTrangThai() {
        return this.trangThai;
    }
    
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }




}


