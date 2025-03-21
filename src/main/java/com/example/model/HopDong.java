package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ngayki;
    private String trangthai;

    @ManyToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachhang;

    @ManyToOne
    @JoinColumn(name = "canho_id")
    private CanHo canho;

    @ManyToOne
    @JoinColumn(name = "dichvunuoc_id")
    private DichVuNuoc dichvunuoc;
}
