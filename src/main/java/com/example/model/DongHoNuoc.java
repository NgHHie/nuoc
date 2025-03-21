package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DongHoNuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float chisocu;
    private float chisomoi;
    private float tongtieuThu;

    @OneToOne
    @JoinColumn(name = "canho_id")
    private CanHo canho;
}
