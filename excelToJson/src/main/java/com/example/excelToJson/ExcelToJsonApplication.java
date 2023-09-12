package com.example.excelToJson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.ExcelToJsonController;
import com.example.service.ExcelToJsonService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ExcelToJsonController.class,ExcelToJsonService.class})
public class ExcelToJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelToJsonApplication.class, args);
	}

}
