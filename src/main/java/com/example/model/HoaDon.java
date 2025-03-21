package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ngaylap;
    private float tongsotien;

    @ManyToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachhang;

    @ManyToOne
    @JoinColumn(name = "hopdong_id")
    private HopDong hopdong;
    
    @OneToOne
    @JoinColumn(name = "donghonuoc_id")
    private DongHoNuoc dongho;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}

	public float getTongsotien() {
		return tongsotien;
	}

	public void setTongsotien(float tongsotien) {
		this.tongsotien = tongsotien;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public HopDong getHopdong() {
		return hopdong;
	}

	public void setHopdong(HopDong hopdong) {
		this.hopdong = hopdong;
	}

	public DongHoNuoc getDongho() {
		return dongho;
	}

	public void setDongho(DongHoNuoc dongho) {
		this.dongho = dongho;
	}
    
    
}
