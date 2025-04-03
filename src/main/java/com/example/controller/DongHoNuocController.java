package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.DongHoNuocService;

@RestController
@RequestMapping("/donghonuoc")
public class DongHoNuocController {
	@Autowired
    private DongHoNuocService dongHoNuocService;

    @PostMapping("/upload-excel")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            dongHoNuocService.saveFromExcel(file);
            return ResponseEntity.ok("Tải lên và lưu thành công!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi: " + e.getMessage());
        }
    }
	
}
