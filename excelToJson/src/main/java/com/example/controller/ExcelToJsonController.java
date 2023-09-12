package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ExcelToJsonModel;
import com.example.service.ExcelToJsonService;

@RestController
public class ExcelToJsonController {
	
	@Autowired
	private ExcelToJsonService excelToJson;
	
	@RequestMapping(path="/convert",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ExcelToJsonModel> convertToJson() throws IOException {
		return excelToJson.convertService();
	}

}
