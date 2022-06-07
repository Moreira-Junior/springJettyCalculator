package com.MoreiraJunior.cloud.tema4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MoreiraJunior.cloud.tema4.appConfig.AppConfig;
import com.MoreiraJunior.cloud.tema4.calculator.Calculator;
import com.MoreiraJunior.cloud.tema4.history.History;
import com.MoreiraJunior.cloud.tema4.operations.Operation;

class HistoryTest {
	
	private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	private Calculator calculator = (Calculator) ac.getBean("createCalculator");
	private History history = (History) ac.getBean("createHistory");
	private Operation sum = (Operation) ac.getBean("sum");
	private Operation sub = (Operation) ac.getBean("sub");
	private Operation mult = (Operation) ac.getBean("mult");
	private Operation div = (Operation) ac.getBean("div");
	private Operation pow = (Operation) ac.getBean("pow");
	
	@BeforeEach
	public void setUp() {
		history.clearList();
	}
	
	@Test
	public void shouldStoreOperations() {
		calculator.calculate(2, 2, sum);
		calculator.calculate(3, 4, mult);
		calculator.calculate(5, 5, div);
		calculator.calculate(6, 6, sub);
		calculator.calculate(10, 0, pow);
		assertEquals(4, history.getHistory().get(0).getResult());
		assertEquals(12, history.getHistory().get(1).getResult());
		assertEquals(1, history.getHistory().get(2).getResult());
		assertEquals(0, history.getHistory().get(3).getResult());
		assertEquals(1, history.getHistory().get(4).getResult());
	}
	
	@Test
	public void shouldStoreOperations2() {
		calculator.calculate(1, 2, sum);
		calculator.calculate(3, 4, sum);
		assertEquals(3, history.getHistory().get(0).getResult());
		assertEquals(7, history.getHistory().get(1).getResult());
	}
	
	@Test
	public void shouldStoreFailedOperations() {
		try {
			calculator.calculate(2, 0, div);			
		} catch(Exception e){e.getMessage();}
		assertEquals(2, history.getHistory().get(0).getNumber1());
		assertEquals(0, history.getHistory().get(0).getNumber2());
	}
}
