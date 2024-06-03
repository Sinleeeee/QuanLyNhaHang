package Model_Hiber;
// Generated Apr 19, 2023 8:08:57 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BanAn generated by hbm2java
 */
@Entity
@Table(name="BanAn"
    ,schema="dbo"
    ,catalog="QUANLYNHAHANG_JAVA_D12"
)
public class BanAn  implements java.io.Serializable {


     private String maBan;
     private String tenBan;
     private Set<DatBan> datBans = new HashSet<DatBan>(0);
     private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);

    public BanAn() {
    }

	
    public BanAn(String maBan, String tenBan) {
        this.maBan = maBan;
        this.tenBan = tenBan;
    }
    public BanAn(String maBan, String tenBan, Set<DatBan> datBans, Set<HoaDon> hoaDons) {
       this.maBan = maBan;
       this.tenBan = tenBan;
       this.datBans = datBans;
       this.hoaDons = hoaDons;
    }
   
     @Id 

    
    @Column(name="MaBan", unique=true, nullable=false, length=15)
    public String getMaBan() {
        return this.maBan;
    }
    
    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    
    @Column(name="TenBan", nullable=false)
    public String getTenBan() {
        return this.tenBan;
    }
    
    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="banAn")
    public Set<DatBan> getDatBans() {
        return this.datBans;
    }
    
    public void setDatBans(Set<DatBan> datBans) {
        this.datBans = datBans;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="banAn")
    public Set<HoaDon> getHoaDons() {
        return this.hoaDons;
    }
    
    public void setHoaDons(Set<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }




}

