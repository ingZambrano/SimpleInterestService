package com.zambrano.test.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Output {
	
	private Integer paymentNumber;
	private Double amount;
	private Date paymentDate;
	
	public Output() {
		
	}
	
	

	public Output(Integer paymentNumber, Double amount, Date paymentDate) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}



	@Override
	public String toString() {
		return "Output [paymentNumber=" + paymentNumber + ", amount=" + amount + ", paymentDate=" + paymentDate + "]";
	}



	@JsonProperty("payment_number")
	public Integer getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	
	@JsonProperty("amount")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@JsonProperty("payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	

}
