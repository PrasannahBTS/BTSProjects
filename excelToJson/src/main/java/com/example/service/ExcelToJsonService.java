package com.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.model.ExcelToJsonModel;

@Service
public class ExcelToJsonService {
	
	public List<ExcelToJsonModel> convertService() throws IOException {
		
		FileInputStream file = new FileInputStream(new File("C:\\Users\\HP\\Downloads\\excelToJson\\excelToJson\\src\\main\\resources\\data.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		List<ExcelToJsonModel> modelList = new ArrayList<>();
		for(Row row: sheet){ 
			ExcelToJsonModel model = new ExcelToJsonModel();
			for(Cell cell: row)  
			{  
				if(cell.getCellType().toString().equals("STRING"))
					model.setName(cell.getStringCellValue());
				else if(cell.getCellType().toString().equals("NUMERIC"))
					model.setAge(cell.getNumericCellValue());
			}
			modelList.add(model);
		}
		return modelList;
		
	}

}
