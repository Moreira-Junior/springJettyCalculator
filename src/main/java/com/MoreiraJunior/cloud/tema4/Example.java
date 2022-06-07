package com.MoreiraJunior.cloud.tema4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MoreiraJunior.cloud.tema4.appConfig.AppConfig;
import com.MoreiraJunior.cloud.tema4.calculator.Calculator;
import com.MoreiraJunior.cloud.tema4.history.History;
import com.MoreiraJunior.cloud.tema4.operations.Operation;

public class Example {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Calculator calculator = (Calculator) ac.getBean("createCalculator");
		History history = (History) ac.getBean("createHistory");
		Operation sum = (Operation) ac.getBean("sum");
		Operation sub = (Operation) ac.getBean("sub");
		Operation mult = (Operation) ac.getBean("mult");
		Operation div = (Operation) ac.getBean("div");
		Operation pow = (Operation) ac.getBean("pow");

		System.out.println(calculator.calculate(2, 2, sum));
		System.out.println(calculator.calculate(3, 2, sum));
		System.out.println(calculator.calculate(2, 2, sub));
		System.out.println(calculator.calculate(2, 2, mult));
		System.out.println(calculator.calculate(2, 2, div));
		System.out.println(calculator.calculate(2, 2, pow));
		try {
			System.out.println(calculator.calculate(2, 0, div));			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(calculator.calculate(2, 2, null));			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(history.getHistory());

		((AnnotationConfigApplicationContext)ac).close();
	}
}
