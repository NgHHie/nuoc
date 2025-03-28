package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.HoaDon;
import com.example.repository.HoaDonRepository;

@Service
public class HoaDonService {
	@Autowired
	private HoaDonRepository hoaDonRepository;
	
	public List<HoaDon> getHoaDonList(LocalDateTime start, LocalDateTime end) {
		if (start == null && end == null) {
	        return hoaDonRepository.findAll();
	    } 
	    if (start != null && end == null) {
	        return hoaDonRepository.findByNgaylapBetween(start, LocalDateTime.now());
	    } 
	    if (start == null && end != null) {
	        return hoaDonRepository.findByNgaylapLessThanEqual(end);
	    }

	    return hoaDonRepository.findByNgaylapBetween(start, end);
	}
}
