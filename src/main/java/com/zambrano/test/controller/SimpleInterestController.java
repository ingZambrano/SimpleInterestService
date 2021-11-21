package com.zambrano.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zambrano.test.modelo.RequestModel;
import com.zambrano.test.pojo.Input;
import com.zambrano.test.service.RequestModelService;
import com.zambrano.test.service.SimpleInterestService;
import com.zambrano.test.utils.InterestUtils;

@RestController
public class SimpleInterestController<T> {
	
	@Autowired
	SimpleInterestService<T> service;
	
	@Autowired
	RequestModelService reqService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/listPayments")
	public List<T> listar(@RequestParam(required = true) Double amount,
			@RequestParam(required = true) Integer terms,
			@RequestParam(required = true) Double rate) {
			
		
		Input input = new Input(amount, terms, rate);
		
		String message = InterestUtils.validarInput(input); 
		
		if(!message.equals("OK")) {
			List<String> ret = new ArrayList<String>();
			ret.add(message);
			return (List<T>) ret;
		}
		
		
		RequestModel requestModel = new RequestModel(new Date(), input.toString());
		reqService.insertRequest(requestModel);
		
		
		return (List<T>) service.calculaInteres(input); 
		
	}

}
