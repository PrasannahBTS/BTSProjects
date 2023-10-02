package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.example.model.AmazonsesModel;

@Service
public class AmazonsesService {
	
	private final String fromMail = "prasannahvenkatesh1.bts@gmail.com";
	
	
	private AWSCredentialsProvider getAwsCredentialProvider() {
	    AWSCredentials awsCredentials =
	        new BasicAWSCredentials("aws-access-key", "aws-secret-key");
	    return new AWSStaticCredentialsProvider(awsCredentials);
	  }
	
	private AmazonSimpleEmailService getEmailSender() {
		AmazonSimpleEmailService awsEmailSender = AmazonSimpleEmailServiceClientBuilder.standard()
				.withCredentials(getAwsCredentialProvider())
				.withRegion("eu-north-1")
				.build();
		return awsEmailSender;
	}
	
	public String sendMail(AmazonsesModel model) {
		
		List tomails = new ArrayList<>(); 
		tomails.add(model.getToMail());
		
		Destination destination = new Destination();
		destination.setToAddresses(tomails);
		
		Content content = new Content();
		content.setData(model.getMessage());
		
		Body body = new Body();
		body.setText(content);
		
		Message message = new Message();
		message.withBody(body);
		message.setSubject(new Content().withData(model.getSubject()));
		
		SendEmailRequest sendEmailRequest = new SendEmailRequest();
		sendEmailRequest.setDestination(destination);
		sendEmailRequest.setSource(fromMail);
		sendEmailRequest.setMessage(message);
		
		getEmailSender().sendEmail(sendEmailRequest);
		return "Mail Sent Successfully!!";
	}

}
