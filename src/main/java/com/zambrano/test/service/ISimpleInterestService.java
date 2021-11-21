package com.zambrano.test.service;

import java.util.List;

import com.zambrano.test.pojo.Input;

public interface ISimpleInterestService<T> {
	
	public List<T> calculaInteres(Input input);

}
