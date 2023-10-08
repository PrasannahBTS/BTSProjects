package com.example.amazonsns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.AmazonsnsController;
import com.example.service.AmazonsnsService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AmazonsnsController.class,AmazonsnsService.class})
public class AmazonsnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonsnsApplication.class, args);
	}

}
