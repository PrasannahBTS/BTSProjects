package com.example.uploadToAWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.controller.UploadToAWSController;
import com.example.service.UploadToAWSService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {UploadToAWSService.class,UploadToAWSController.class})
public class UploadToAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadToAwsApplication.class, args);
	}

}
