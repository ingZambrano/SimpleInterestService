package com.zambrano.test.modelo;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ResponseModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private Date fechaRequest;
	@Column(length = 10000)
	private String output;
	
	public ResponseModel() {
		
	}
	public ResponseModel(Date fechaRequest, String output) {
		super();
		
		this.fechaRequest = fechaRequest;
		this.output = output;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseModel other = (ResponseModel) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "ResponseModel [id=" + id + "]";
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
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	
	
	
	
	

}
