package edu.ycp.cs320.amcdevitt.model;


public class Numbers {
	private Double first, second, third;
	
	public Numbers() {
	}
	
	public void setFirst(Double first) {
		this.first = first;
	}
	
	public Double getFirst() {
		return first;
	}
	
	public void setSecond(Double second) {
		this.second = second;
	}
	
	public Double getSecond() {
		return second;
	}
	
	public void setThird(Double third) {
		this.third = third;
	}
	
	public Double getThird() {
		return third;
	}
	
	public Double getProduct(Double first, Double second) {
		Double product = first*second;
		return product;
	}
	
	public Double getSum(Double first, Double second, Double third) {
		return first+second+third;
	}
}
