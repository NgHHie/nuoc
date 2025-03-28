package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.KhachHang;
import com.example.model.ThongKeKhachHang;
import com.example.model.builder.BasicThongKe;
import com.example.service.KhachHangService;
import com.example.service.ThongKeKhachHangService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/thongkekhachhang")
public class ThongKeKhachHangController {
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private ThongKeKhachHangService thongKeKhachHangService;
	
	@GetMapping
	public List<Map<String, Object>> thongKe(
	        @RequestParam(required = false) Float start,
	        @RequestParam(required = false) Float end) {
		System.out.println(start);
		List<KhachHang> khList = khachHangService.getAllKhachHang();
		List<Map<String, Object>> thongKeList = new ArrayList<>();
		
		for (KhachHang kh : khList) {
			ThongKeKhachHang thongKe = thongKeKhachHangService.getBasicThongKeFromKH(kh);
			if ((start == null && end != null && thongKe.getDoanhthu() <= end) ||  
			    (start != null && end == null && thongKe.getDoanhthu() >= start) ||  
			    (start != null && end != null && thongKe.getDoanhthu() >= start && thongKe.getDoanhthu() <= end) ||  
			    (start == null && end == null)) { 
				
				Map<String, Object> thongKeMap = new HashMap<>();
				thongKeMap.put("khachHang", kh);  // Đảm bảo KhachHang có @JsonIgnore hoặc @JsonIdentityInfo để tránh vòng lặp
				thongKeMap.put("thongKe", thongKe);
				
				thongKeList.add(thongKeMap);
			}
		}
		
		return thongKeList;
	}
	
	@GetMapping("/{idkh}")
	public List<ThongKeKhachHang> thongKeKhachHang(
			@PathVariable int idkh,
			@RequestParam(required = false) LocalDateTime start,
			@RequestParam(required = false) LocalDateTime end) {
		
		KhachHang kh = khachHangService.getKhachHangById(idkh).orElse(null);	
		ThongKeKhachHang thongKeBasic = thongKeKhachHangService.getBasicThongKeFromKH(kh);
		ThongKeKhachHang thongKeAdvance = thongKeKhachHangService.getAdvanceThongKeFromKH(kh, start, end);
		
		return Arrays.asList(thongKeBasic, thongKeAdvance);
	}
}

