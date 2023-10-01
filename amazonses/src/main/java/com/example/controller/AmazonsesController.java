package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AmazonsesModel;
import com.example.service.AmazonsesService;

@RestController
public class AmazonsesController {
	
	@Autowired
	AmazonsesService amazonsesService;
	
	@RequestMapping(value="/sendmail",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendMail(@RequestBody AmazonsesModel model) {
		return amazonsesService.sendMail(model);
	}

}
