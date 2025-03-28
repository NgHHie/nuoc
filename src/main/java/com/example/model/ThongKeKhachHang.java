package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
public class ThongKeKhachHang extends KhachHang{	
	private float doanhthu;
	private int sodonhang;
	private String xephang;	
	private LocalDateTime start, end;
	private LocalDateTime lastOrderDate;
    private long inactiveDays;
    private LocalDateTime firstOrderDate;
    private int rewardPoints;
}
