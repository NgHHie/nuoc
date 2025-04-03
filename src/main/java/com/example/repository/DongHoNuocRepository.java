package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.DongHoNuoc;

@Repository
public interface DongHoNuocRepository extends JpaRepository<DongHoNuoc, Integer>{
	
	
}
