package com.zambrano.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zambrano.test.modelo.RequestModel;
import com.zambrano.test.repository.IRequestRepository;

@Service
public class RequestModelService implements IRequestModelService {
	
	@Autowired
	IRequestRepository rep;

	@Override
	public RequestModel insertRequest(RequestModel request) {
		
		return rep.save(request);
	}

}
