package com.example.model.builder;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.HoaDon;
import com.example.model.KhachHang;
import com.example.model.ThongKeKhachHang;
import com.example.service.HoaDonService;
import com.example.service.KhachHangService;
import com.example.service.ThongKeKhachHangService;

public abstract class ThongKeKHBuilder {
	protected ThongKeKhachHang thongKeKh;
	
	@Autowired
	private ThongKeKhachHangService thongKeKHService;
	@Autowired
	private HoaDonService hoaDonService;
	
	public ThongKeKHBuilder setBetween(LocalDateTime start, LocalDateTime end) {
		thongKeKh.setStart(start);
		thongKeKh.setEnd(end);
		return this;
	}
	
	public ThongKeKHBuilder fromKhachHang(KhachHang kh) {
		thongKeKh = new ThongKeKhachHang();
		thongKeKh.setId(kh.getId());
		thongKeKh.setEmail(kh.getEmail());
		thongKeKh.setHoten(kh.getHoten());
		thongKeKh.setSodienthoai(kh.getSodienthoai());
		thongKeKh.setCanho(kh.getCanho());
		thongKeKh.setHoadon(kh.getHoadon());
		return this;
	}
	
	public abstract ThongKeKHBuilder buildDoanhThu();
	
	public ThongKeKHBuilder buildActivity() {
		return this;
	}
	
	public ThongKeKhachHang getThongKe() {
		return thongKeKh;
	}
	
}
