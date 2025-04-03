package com.example.utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.CanHo;
import com.example.model.DongHoNuoc;
import com.example.repository.CanHoRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
	public static List<DongHoNuoc> excelToDongHoNuoc(MultipartFile file, CanHoRepository canHoRepository) {
	    List<DongHoNuoc> dongHoNuocList = new ArrayList<>();

	    try (InputStream inputStream = file.getInputStream();
	         Workbook workbook = new XSSFWorkbook(inputStream)) {

	        Sheet sheet = workbook.getSheetAt(0); 
	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; 
	            if (row.getPhysicalNumberOfCells() == 0) continue;

	            DongHoNuoc dongHoNuoc = new DongHoNuoc();

	            if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.NUMERIC) {
	                dongHoNuoc.setChisocu((float) row.getCell(0).getNumericCellValue());
	            }

	            if (row.getCell(1) != null && row.getCell(1).getCellType() == CellType.NUMERIC) {
	                dongHoNuoc.setChisomoi((float) row.getCell(1).getNumericCellValue());
	            }

	            if (row.getCell(2) != null && row.getCell(2).getCellType() == CellType.NUMERIC) {
	                int canHoId = (int) row.getCell(2).getNumericCellValue();
	                CanHo canHo = canHoRepository.findById(canHoId)
	                        .orElseThrow(() -> new RuntimeException("CanHo not found with ID: " + canHoId));
	                dongHoNuoc.setCanho(canHo);
	            }

	            dongHoNuocList.add(dongHoNuoc);
	        }

	    } catch (IOException e) {
	        throw new RuntimeException("Lỗi đọc file Excel: " + e.getMessage());
	    }
	    return dongHoNuocList;
	}

}
