package com.example.charts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.charts.model.ChartData;
import com.example.charts.model.ChartModel;

@Service
public class ChartService {
	
	@Autowired
	ChartModel chartModel;
	@Autowired
	ChartData chartData;
	
	public void addValues(ChartModel model) {
		chartModel.setTitle(model.getTitle());
		chartModel.setValues(model.getValues());
		for (ChartData data : chartModel.getValues()) {
			chartData.setKey(data.getKey());
			chartData.setValue(data.getValue());
		}
	}
	
	public ChartModel generateChart() {
		System.out.println(chartModel.getTitle());
		return chartModel;
	}

}
