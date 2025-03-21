package com.example.service;

import com.example.model.CanHo;
import com.example.model.HoaDon;
import com.example.model.KhachHang;
import com.example.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    public Optional<KhachHang> getKhachHangById(int id) {
        return khachHangRepository.findById(id);
    }

    public List<KhachHang> getKhachHangByName(String name) {
        return khachHangRepository.findByHoten(name);
    }

    public KhachHang saveKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    public void deleteKhachHang(int id) {
        khachHangRepository.deleteById(id);
    }
    
    public KhachHang getKhachHangByCanHo(CanHo canho) {
        return khachHangRepository.findByCanHo(canho);
    }

    public KhachHang getKhachHangByHoaDon(HoaDon hoadon) {
        return khachHangRepository.findByHoaDon(hoadon);
    }
}
