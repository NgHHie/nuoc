package com.example.controller;

import com.example.NuocApplication;
import com.example.model.NguoiDung;
import com.example.repository.NguoiDungRepository;
import com.example.service.NguoiDungService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nguoidung")
public class NguoiDungController {
	
	@Autowired
	private NguoiDungService nguoiDungService;

	
	@GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
	
	@PostMapping("/login")
	public boolean checkNguoiDung(@RequestBody NguoiDung nguoiDung) {
	    NguoiDung nguoiDung2 = nguoiDungService.findByTendangnhap(nguoiDung.getTendangnhap());

	    if (nguoiDung2 != null && nguoiDung2.getMatkhau().equals(nguoiDung.getMatkhau())) {
	        return true;
	    } 

	    return false;
	}
	
	
	
	


}
