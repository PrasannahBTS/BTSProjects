package com.example.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class UploadToAWSService {
	private static final String BUCKET = "your-aws-bucket-name";
	
	public String uploadFile(Model model, String description, @RequestParam("file") MultipartFile multipart) {
		
	    String message = "File Uploaded Sucessfully";
		
		S3Client client = S3Client.builder().region(Region.EU_NORTH_1)
				.credentialsProvider(StaticCredentialsProvider
						.create(AwsBasicCredentials.create("aws-access-key", "aws-secret-key")))
				.build();
		
		PutObjectRequest request = PutObjectRequest.builder()
				.bucket(BUCKET)
				.key(multipart.getOriginalFilename())
				.build();
		
		try {
			client.putObject(request, RequestBody.fromInputStream(multipart.getInputStream(), multipart.getInputStream().available()));
		} catch (AwsServiceException | SdkClientException | IOException e) {
			message = "Error uploading file: " + e.getMessage();
		}
		
		model.addAttribute("message", message);
		
		return "result";
	}
}
