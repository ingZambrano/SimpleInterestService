package com.zambrano.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zambrano.test.modelo.ResponseModel;
import com.zambrano.test.repository.IResponseRepository;

@Service
public class ResponseModelService implements IResponseModelService {

	@Autowired
	IResponseRepository rep;
	
	@Override
	public ResponseModel insertRequest(ResponseModel request) {
		return rep.save(request);
	}

}
