package com.example.charts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.charts.model.ChartModel;
import com.example.charts.service.ChartService;

@RestController
public class ChartController {
	
	@Autowired
	ChartService chartService;
	
	@RequestMapping(value="/getDetails", method= RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String getDetails(@RequestBody ChartModel chartModel) {
		chartService.addValues(chartModel);
		return "Added Sucessfully";
	}
	@RequestMapping(value="/displayDetails", method= RequestMethod.GET)
	public ModelAndView displayDetails(Model model) {
		model.addAttribute("values", chartService.generateChart().getValues());
		model.addAttribute("title",chartService.generateChart().getTitle());
		return new ModelAndView("chart");
	}

}
