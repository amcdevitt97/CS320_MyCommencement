package edu.ycp.cs320.amcdevitt.controller;

import edu.ycp.cs320.amcdevitt.model.Numbers;

public class NumbersController {
	
	private Numbers model = new Numbers();
	
	public void setModel(Numbers model) {
		this.model = model;
	}
	
	public Double add(Double first, Double second, Double third) {
		return model.getSum(first, second, third);
	}
	
	public Double multiply(Double first, Double second) {
		return model.getProduct(first, second);
	}
}