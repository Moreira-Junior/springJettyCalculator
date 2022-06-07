package com.MoreiraJunior.cloud.tema4.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.MoreiraJunior.cloud.tema4.history.History;
import com.MoreiraJunior.cloud.tema4.operations.Div;
import com.MoreiraJunior.cloud.tema4.operations.Operation;

public class Calculator {
	
	@Autowired
	private History history;
	@Autowired
	private ApplicationContext applicationContext;
	
	public double calculate (double x, double y, Operation operation) {
		if(operation == null) {
			history.addOperation(operation);
			throw new IllegalArgumentException("Arguments cannot be null!");
		}
		operation = (Operation) applicationContext.getBean(operation.getClass());
		operation.setNumber1(x);
		operation.setNumber2(y);
		if(y == 0 && operation instanceof Div) {
			history.addOperation(operation);
			throw new IllegalArgumentException("Cannot divide by zero!");
		}
		double result = operation.calculate();
		history.addOperation(operation);
		return result;
	}
}
