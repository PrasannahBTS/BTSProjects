package com.example.charts.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ChartModel {
	
	private String title;
	private List<ChartData> values;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ChartData> getValues() {
		return values;
	}
	public void setValues(List<ChartData> values) {
		this.values = values;
	}
	
}
