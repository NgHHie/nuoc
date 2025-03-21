package com.example.service;

import com.example.model.NguoiDung;
import com.example.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    public NguoiDung findByTendangnhap(String tendangnhap) {
        return nguoiDungRepository.findByTendangnhap(tendangnhap);
    }
}
