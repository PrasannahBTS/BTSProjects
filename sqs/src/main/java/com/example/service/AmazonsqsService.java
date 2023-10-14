package com.example.service;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.model.AmazonsqsModel;

@Service
public class AmazonsqsService {
		
	private AmazonSQS amazonSNSClient() {
        return AmazonSQSClientBuilder
                .standard()
                .withRegion("ap-south-1")
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("access_key", "secret_access_key")))
                .build();
    }
	
	public String sendMessages(AmazonsqsModel model) {
		System.out.println("Message Sent-> "+model.getMessage());
		SendMessageRequest sendMessageRequest = new SendMessageRequest();
		sendMessageRequest.setQueueUrl("queue_url");
		sendMessageRequest.setMessageBody(model.getMessage());
		sendMessageRequest.setMessageGroupId("bts");
		this.amazonSNSClient().sendMessage(sendMessageRequest);
		this.receivedMessage();
		return "Message Sent";
	}
	
	
	public String receivedMessage() {
		ReceiveMessageResult messageList = this.amazonSNSClient().receiveMessage("queue_url");
		for(Message message : messageList.getMessages()) {
			System.out.println("Message Received -> " + message.getBody());
			this.amazonSNSClient().deleteMessage("queue_url", message.getReceiptHandle());
		}
		return "Received";
	}

}
