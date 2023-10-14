package com.example.sqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.AmazonsqsController;
import com.example.service.AmazonsqsService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AmazonsqsController.class,AmazonsqsService.class})
public class SqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsApplication.class, args);
	}

}
