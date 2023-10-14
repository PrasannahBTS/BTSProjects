package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AmazonsqsModel;
import com.example.service.AmazonsqsService;

@RestController
public class AmazonsqsController {
	
	@Autowired
	AmazonsqsService amazonsqsService;
	
	@RequestMapping(value = "/send",method = RequestMethod.POST)
	public String sendNotification(@RequestBody AmazonsqsModel model) {
		return amazonsqsService.sendMessages(model);
	}

}
