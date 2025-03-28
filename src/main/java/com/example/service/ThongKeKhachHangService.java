package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.KhachHang;
import com.example.model.ThongKeKhachHang;
import com.example.model.builder.AdvanceThongKe;
import com.example.model.builder.BasicThongKe;
import com.example.model.builder.ThongKeDirector;
import com.example.repository.KhachHangRepository;

@Service
public class ThongKeKhachHangService {
	@Autowired
	private KhachHangService khachHangService;

	public ThongKeKhachHang getBasicThongKeFromKH(KhachHang kh) {
		ThongKeDirector director = new ThongKeDirector();
		BasicThongKe basicBuilder = new BasicThongKe();
		director.build(basicBuilder, kh);
		ThongKeKhachHang thongKe = basicBuilder.getThongKe();
		return thongKe;
	}
	
	public ThongKeKhachHang getAdvanceThongKeFromKH(KhachHang kh, LocalDateTime start, LocalDateTime end) {
		ThongKeDirector director = new ThongKeDirector();
		AdvanceThongKe advanceBuilder = new AdvanceThongKe();
		director.build(advanceBuilder, kh, start, end);
		ThongKeKhachHang thongKe = advanceBuilder.getThongKe();
		return thongKe;
	}
}
