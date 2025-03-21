package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String hoten;
    private String sodienthoai;
    private String email;

    @OneToMany(mappedBy = "khachhang")
    @JsonIgnore
    private List<CanHo> canho;
    
    @OneToMany(mappedBy = "khachhang")
    @JsonIgnore
    private List<HoaDon> hoadon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CanHo> getCanho() {
		return canho;
	}

	public void setCanho(List<CanHo> canho) {
		this.canho = canho;
	}

	public List<HoaDon> getHoadon() {
		return hoadon;
	}

	public void setHoadon(List<HoaDon> hoadon) {
		this.hoadon = hoadon;
	}

	
}
