package com.zambrano.test.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.zambrano.test.pojo.Input;

public class InterestUtils {

	  public static Date asDate(LocalDate localDate) {
		  return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	  }
	
	  public static Date asDate(LocalDateTime localDateTime) {
		  return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	  }
	
	  public static LocalDate asLocalDate(Date date) {
		  return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	  }
	
	  public static LocalDateTime asLocalDateTime(Date date) {
		  return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	  }
	  
	  public static Date addWeeksToCurrent(int numberWeeks) {	
		  LocalDate today = LocalDate.now();
		  LocalDate nextWeek = today.plus(numberWeeks, ChronoUnit.WEEKS);
		    
		  return asDate(nextWeek);
	  }
	  
	  public static String validarInput(Input input) {
		  
		
		  
		  if(input.getTerms() < 4 || input.getTerms() > 52) {
			  return "Warning: Tiempo mínimo de pago son 4 semanas, tiempo máximo de pago son 52";
		  }
		  
		  if(input.getRate() < 1.0 || input.getRate() > 100.0) {
			  return "Warning: La tasa debe ser mayor a 1% y menor al 100%";
		  }
		  
		  if(input.getAmount() < 1.0 || input.getAmount() > 999999.0) {
			  return "Warning: El monto minimo de credito es de 1.0 y el maximo de 999999.0";
		  }
		  
		  
		  return "OK";
	  }
	  
}