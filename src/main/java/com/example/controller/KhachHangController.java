package com.example.controller;

import com.example.model.CanHo;
import com.example.model.HoaDon;
import com.example.model.KhachHang;
import com.example.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public List<KhachHang> getAllKhachHang() {
        return khachHangService.getAllKhachHang();
    }

    @GetMapping("/{id}")
    public Optional<KhachHang> getKhachHangById(@PathVariable int id) {
        return khachHangService.getKhachHangById(id);
    }

    @GetMapping("/search")
    public List<KhachHang> getKhachHangByName(@RequestParam String name) {
        return khachHangService.getKhachHangByName(name);
    }

    @PostMapping
    public KhachHang createKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangService.saveKhachHang(khachHang);
    }

    @PutMapping("/{id}")
    public KhachHang updateKhachHang(@PathVariable int id, @RequestBody KhachHang khachHang) {
    	khachHang.setId(id);
        return khachHangService.saveKhachHang(khachHang);
    }

    @DeleteMapping("/{id}")
    public String deleteKhachHang(@PathVariable int id) {
        khachHangService.deleteKhachHang(id);
        return "Khách hàng đã được xóa thành công!";
    }
    
    @GetMapping("/searchbycanho/{canHoId}")
    public KhachHang getKhachHangByCanHo(@PathVariable int canHoId) {
        CanHo canHo = new CanHo();
        canHo.setId(canHoId);
        return khachHangService.getKhachHangByCanHo(canHo);
    }

    @GetMapping("/searchbyhoadon/{hoaDonId}")
    public KhachHang getKhachHangByHoaDon(@PathVariable int hoaDonId) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setId(hoaDonId);
        return khachHangService.getKhachHangByHoaDon(hoaDon);
    }
}
