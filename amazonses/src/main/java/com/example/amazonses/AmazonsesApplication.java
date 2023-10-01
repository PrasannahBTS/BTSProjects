package com.example.amazonses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.AmazonsesController;
import com.example.service.AmazonsesService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AmazonsesController.class,AmazonsesService.class})
public class AmazonsesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonsesApplication.class, args);
	}

}
