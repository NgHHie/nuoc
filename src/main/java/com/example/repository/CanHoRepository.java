package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CanHo;

@Repository
public interface CanHoRepository extends JpaRepository<CanHo, Integer>{

}
