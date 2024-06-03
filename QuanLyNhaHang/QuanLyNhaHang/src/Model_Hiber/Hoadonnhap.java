package Model_Hiber;
// Generated Apr 19, 2023 8:08:57 PM by Hibernate Tools 4.3.1


import java.io.Serializable ;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Hoadonnhap generated by hbm2java
 */
@Entity
@Table(name="HOADONNHAP"
    ,schema="dbo"
    ,catalog="QUANLYNHAHANG_JAVA_D12"
)
public class Hoadonnhap  implements java.io.Serializable  {


     private String maHdn;
     private NhanVien nhanVien;
     private Date ngayTao;
     private String ghiChu;
     private BigDecimal tongTien;
     private Set<Chitiethoadonnhap> chitiethoadonnhaps = new HashSet<Chitiethoadonnhap>(0);

    public Hoadonnhap() {
    }

	
    public Hoadonnhap(String maHdn, NhanVien nhanVien, Date ngayTao, BigDecimal tongTien) {
        this.maHdn = maHdn;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
    }
    public Hoadonnhap(String maHdn, NhanVien nhanVien, Date ngayTao, String ghiChu, BigDecimal tongTien, Set<Chitiethoadonnhap> chitiethoadonnhaps) {
       this.maHdn = maHdn;
       this.nhanVien = nhanVien;
       this.ngayTao = ngayTao;
       this.ghiChu = ghiChu;
       this.tongTien = tongTien;
       this.chitiethoadonnhaps = chitiethoadonnhaps;
    }
   
     @Id 

    
    @Column(name="MaHDN", unique=true, nullable=false, length=5)
    public String getMaHdn() {
        return this.maHdn;
    }
    
    public void setMaHdn(String maHdn) {
        this.maHdn = maHdn;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MaNV")
    public NhanVien getNhanVien() {
        return this.nhanVien;
    }
    
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NgayTao", nullable=false, length=10)
    public Date getNgayTao() {
        return this.ngayTao;
    }
    
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    
    @Column(name="GhiChu")
    public String getGhiChu() {
        return this.ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
    @Column(name="TongTien", nullable=false, scale=4)
    public BigDecimal getTongTien() {
        return this.tongTien;
    }
    
    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hoadonnhap")
    public Set<Chitiethoadonnhap> getChitiethoadonnhaps() {
        return this.chitiethoadonnhaps;
    }
    
    public void setChitiethoadonnhaps(Set<Chitiethoadonnhap> chitiethoadonnhaps) {
        this.chitiethoadonnhaps = chitiethoadonnhaps;
    }




}


