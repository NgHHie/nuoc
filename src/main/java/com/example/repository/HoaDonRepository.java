package com.example.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer>{
	List<HoaDon> findByNgaylapBetween(LocalDateTime start, LocalDateTime end);
	List<HoaDon> findByNgaylapLessThanEqual(LocalDateTime end);

}
