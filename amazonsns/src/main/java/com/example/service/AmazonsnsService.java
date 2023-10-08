package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.example.model.AmazonsnsModel;

@Service
public class AmazonsnsService {
	
	private static final String AWS_SNS_SMS_TYPE = "AWS.SNS.SMS.SMSType";
    private static final String AWS_SNS_SMS_TYPE_VALUE = "Transactional";
    private static final String AWS_SNS_DATA_TYPE = "String";
	
	private AmazonSNSClient amazonSNSClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("access-key", "secret-access-key")))
                .build();
    }
	
	public String sendNotification(AmazonsnsModel model) {
		
		System.out.println("Message -> "+model.getMessage());
		
		Map<String, MessageAttributeValue> smsAttributes =
                new HashMap<>();
        smsAttributes.put(AWS_SNS_SMS_TYPE, new MessageAttributeValue()
                .withStringValue(AWS_SNS_SMS_TYPE_VALUE)
                .withDataType(AWS_SNS_DATA_TYPE));
		
		AmazonSNSClient amazonSNSClient = amazonSNSClient();
		PublishRequest publishRequest = new PublishRequest();
		publishRequest.setTopicArn("arn:aws:sns:ap-south-1:539436082026:AWSSMSIND");
		publishRequest.setMessage(model.getMessage());
		publishRequest.setMessageAttributes(smsAttributes);
		amazonSNSClient.publish(publishRequest);
		return "Notification Sent";
	}

}
