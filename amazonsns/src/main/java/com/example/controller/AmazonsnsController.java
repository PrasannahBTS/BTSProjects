package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AmazonsnsModel;
import com.example.service.AmazonsnsService;

@RestController
public class AmazonsnsController {
	
	@Autowired
	AmazonsnsService amazonsnsService;
	
	@RequestMapping(value = "/send",method = RequestMethod.POST)
	public String sendNotification(@RequestBody AmazonsnsModel model) {
		return amazonsnsService.sendNotification(model);
	}

}
