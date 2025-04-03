package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.DongHoNuoc;
import com.example.repository.CanHoRepository;
import com.example.repository.DongHoNuocRepository;
import com.example.utils.ExcelHelper;

@Service
public class DongHoNuocService {
	@Autowired
	private DongHoNuocRepository dongHoNuocRepository;
	@Autowired
	private CanHoRepository canHoRepository;
	
	public void saveMultipleRecords(List<DongHoNuoc> list) {
		dongHoNuocRepository.saveAll(list);
	}
	
	public void saveFromExcel(MultipartFile file) {
        List<DongHoNuoc> records = ExcelHelper.excelToDongHoNuoc(file, canHoRepository);
        dongHoNuocRepository.saveAll(records);
    }
	
}
