package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.UploadToAWSService;

@RestController
public class UploadToAWSController {
	@Autowired
	UploadToAWSService uploadToAWSService;
	
	@RequestMapping(path="/home",method=RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("upload");
	}
	
	@RequestMapping(path="/upload",method=RequestMethod.POST)
	public ModelAndView uploadFile(Model model, String description, @RequestParam("file") MultipartFile multipart) {
		return new ModelAndView(uploadToAWSService.uploadFile(model,description,multipart));
	}

}
