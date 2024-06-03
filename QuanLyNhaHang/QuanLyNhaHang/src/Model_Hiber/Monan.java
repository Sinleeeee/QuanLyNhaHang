package Model_Hiber;
// Generated Apr 19, 2023 8:08:57 PM by Hibernate Tools 4.3.1


import java.io.Serializable ;
import java.math.BigDecimal;
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

/**
 * Monan generated by hbm2java
 */
@Entity
@Table(name="MONAN"
    ,schema="dbo"
    ,catalog="QUANLYNHAHANG_JAVA_D12"
)
public class Monan  implements java.io.Serializable  {


     private String maMon;
     private Loai loai;
     private String tenMonAn;
     private String trangThai;
     private BigDecimal donGia;
     private String hinh;
     private String moTa;
     private Set<Cthd> cthds = new HashSet<Cthd>(0);
     private Set<Duockhuyenmai> duockhuyenmais = new HashSet<Duockhuyenmai>(0);

    public Monan() {
    }

	
    public Monan(String maMon, Loai loai, String tenMonAn, String trangThai, BigDecimal donGia, String hinh, String moTa) {
        this.maMon = maMon;
        this.loai = loai;
        this.tenMonAn = tenMonAn;
        this.trangThai = trangThai;
        this.donGia = donGia;
        this.hinh = hinh;
        this.moTa = moTa;
    }
    public Monan(String maMon, Loai loai, String tenMonAn, String trangThai, BigDecimal donGia, String hinh, String moTa, Set<Cthd> cthds, Set<Duockhuyenmai> duockhuyenmais) {
       this.maMon = maMon;
       this.loai = loai;
       this.tenMonAn = tenMonAn;
       this.trangThai = trangThai;
       this.donGia = donGia;
       this.hinh = hinh;
       this.moTa = moTa;
       this.cthds = cthds;
       this.duockhuyenmais = duockhuyenmais;
    }
   
     @Id 

    
    @Column(name="MaMon", unique=true, nullable=false, length=5)
    public String getMaMon() {
        return this.maMon;
    }
    
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MaLoai", nullable=false)
    public Loai getLoai() {
        return this.loai;
    }
    
    public void setLoai(Loai loai) {
        this.loai = loai;
    }

    
    @Column(name="TenMonAn", nullable=false)
    public String getTenMonAn() {
        return this.tenMonAn;
    }
    
    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    
    @Column(name="TrangThai", nullable=false, length=40)
    public String getTrangThai() {
        return this.trangThai;
    }
    
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    @Column(name="DonGia", nullable=false, scale=4)
    public BigDecimal getDonGia() {
        return this.donGia;
    }
    
    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    
    @Column(name="Hinh", nullable=false, length=100)
    public String getHinh() {
        return this.hinh;
    }
    
    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    
    @Column(name="MoTa", nullable=false)
    public String getMoTa() {
        return this.moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="monan")
    public Set<Cthd> getCthds() {
        return this.cthds;
    }
    
    public void setCthds(Set<Cthd> cthds) {
        this.cthds = cthds;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="monan")
    public Set<Duockhuyenmai> getDuockhuyenmais() {
        return this.duockhuyenmais;
    }
    
    public void setDuockhuyenmais(Set<Duockhuyenmai> duockhuyenmais) {
        this.duockhuyenmais = duockhuyenmais;
    }




}


