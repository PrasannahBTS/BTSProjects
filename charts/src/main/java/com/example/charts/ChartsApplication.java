package com.example.charts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.charts.controller.ChartController;
import com.example.charts.model.ChartModel;
import com.example.charts.service.ChartService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ChartController.class,ChartService.class,ChartModel.class})
public class ChartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartsApplication.class, args);
	}

}
