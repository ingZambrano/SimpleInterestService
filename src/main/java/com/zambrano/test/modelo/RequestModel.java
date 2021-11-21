package com.zambrano.test.modelo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class RequestModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date fechaRequest;
	private String input;
	
	public RequestModel() {
		
	}
	public RequestModel(Date fechaRequest, String input) {
		super();
		
		this.fechaRequest = fechaRequest;
		this.input = input;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaRequest, id, input);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestModel other = (RequestModel) obj;
		return Objects.equals(fechaRequest, other.fechaRequest) && id == other.id && Objects.equals(input, other.input);
	}
	@Override
	public String toString() {
		return "RequestModel [id=" + id + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFechaRequest() {
		return fechaRequest;
	}
	public void setFechaRequest(Date fechaRequest) {
		this.fechaRequest = fechaRequest;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	
			
}
