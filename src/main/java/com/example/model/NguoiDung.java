package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Getter
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tendangnhap;
    private String matkhau;
	public String getMatkhau() {
		return matkhau;
	}
	public String getTendangnhap() {	
		return tendangnhap;
	}
}
