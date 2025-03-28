package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@ToString(exclude = {"canho", "hoadon"})
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
}
