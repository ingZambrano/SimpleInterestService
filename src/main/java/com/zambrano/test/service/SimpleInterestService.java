package com.zambrano.test.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zambrano.test.modelo.ResponseModel;
import com.zambrano.test.pojo.Input;
import com.zambrano.test.pojo.Output;
import com.zambrano.test.utils.InterestUtils;

@Service
public class SimpleInterestService<T> implements ISimpleInterestService<Output> {
	
	@Autowired
	ResponseModelService responseServ;

	@Override
	public List<Output> calculaInteres(Input input) {
		
		//Formula
		//A = P(1 + rt)
		
		Output output;		
		List<Output> ret;
		
		Double principal = input.getAmount();
		Double rate = input.getRate()/100;
		Integer time = input.getTerms();
		
		Double totalAmount = principal*(1+(rate*time));
		
		ret = new ArrayList<Output>();
		
		List<Double> listPagos = getListPayments(time, totalAmount);
		
		for(int i=0; i<time; i++){
			output = new Output();
			output.setPaymentNumber(i+1);
			output.setPaymentDate(InterestUtils.addWeeksToCurrent(i+1));
			output.setAmount(listPagos.get(i));
			ret.add(output);
		}
		
		//Inserta registro del response
		ResponseModel responseModel = new ResponseModel(new Date(), ret.toString());
		
		responseServ.insertRequest(responseModel);
		
		return ret;
	}
	
	public List<Double> getListPayments(Integer time, Double principalAmmount){
		
		BigDecimal abonos = new BigDecimal(String.valueOf(principalAmmount/time));
		abonos = abonos.setScale(2, RoundingMode.HALF_UP);
		List<Double> ret = new ArrayList<Double>();
		Double suma = 0.0;
		
		for(int i=0; i<time-1; i++){
		
			ret.add(abonos.doubleValue());
			suma +=abonos.doubleValue();	
		}
		
		ret.add(new BigDecimal(String.valueOf(principalAmmount-suma))
				.setScale(2, RoundingMode.HALF_UP).doubleValue());
		
		return ret;
	}
	
	

}
