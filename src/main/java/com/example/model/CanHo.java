package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class CanHo {
    @Id
    private int id;

    private int socanho;
    private String toanha;

    @ManyToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachhang;

    @OneToOne(mappedBy = "canho")
    private DongHoNuoc donghonuoc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSocanho() {
		return socanho;
	}

	public void setSocanho(int socanho) {
		this.socanho = socanho;
	}

	public String getToanha() {
		return toanha;
	}

	public void setToanha(String toanha) {
		this.toanha = toanha;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public DongHoNuoc getDonghonuoc() {
		return donghonuoc;
	}

	public void setDonghonuoc(DongHoNuoc donghonuoc) {
		this.donghonuoc = donghonuoc;
	}

    
}
