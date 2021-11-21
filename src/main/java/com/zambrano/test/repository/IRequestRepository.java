package com.zambrano.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.zambrano.test.modelo.RequestModel;

public interface IRequestRepository extends CrudRepository<RequestModel, Integer>{

}
