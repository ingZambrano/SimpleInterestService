package com.zambrano.test.pojo;

public class Input {
	
	private Double amount;
	private Integer terms;
	private Double rate;
	
	
	public Input() {
		
	}
	
	public Input(Double amount, Integer terms, Double rate) {
		super();
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}

	

	@Override
	public String toString() {
		return "Input [amount=" + amount + ", terms=" + terms + ", rate=" + rate + "]";
	}

	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Integer getTerms() {
		return terms;
	}


	public void setTerms(Integer terms) {
		this.terms = terms;
	}


	public Double getRate() {
		return rate;
	}


	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	
	

}
