package com.example.model.builder;

import java.time.LocalDateTime;

import com.example.model.KhachHang;

public class ThongKeDirector {
	public void build(ThongKeKHBuilder builder, KhachHang kh, LocalDateTime start, LocalDateTime end) {
		if(builder instanceof BasicThongKe) {
			((BasicThongKe) builder)
				.fromKhachHang(kh)
				.buildDoanhThu();
		}
		else if (builder instanceof AdvanceThongKe) {
			((AdvanceThongKe) builder)
				.fromKhachHang(kh)
				.setBetween(start, end)
				.buildDoanhThu()
				.buildActivity();
		}
	}
	
	public void build(ThongKeKHBuilder builder, KhachHang kh) {
	    build(builder, kh, null, null); 
	}
}
