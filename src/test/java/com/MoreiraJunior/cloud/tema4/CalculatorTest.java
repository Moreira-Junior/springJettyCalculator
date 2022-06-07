package com.MoreiraJunior.cloud.tema4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MoreiraJunior.cloud.tema4.appConfig.AppConfig;
import com.MoreiraJunior.cloud.tema4.calculator.Calculator;
import com.MoreiraJunior.cloud.tema4.history.History;
import com.MoreiraJunior.cloud.tema4.operations.Operation;

class CalculatorTest {

	private ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	private Calculator calculator = (Calculator) ac.getBean("createCalculator");
	private History history = (History) ac.getBean("createHistory");
	private Operation sum = (Operation) ac.getBean("sum");
	private Operation sub = (Operation) ac.getBean("sub");
	private Operation mult = (Operation) ac.getBean("mult");
	private Operation div = (Operation) ac.getBean("div");
	private Operation pow = (Operation) ac.getBean("pow");

	@Test
	public void shouldSum() {
		assertEquals(4, calculator.calculate(2, 2, sum));
	}

	@Test
	public void shouldSub() {
		assertEquals(0, calculator.calculate(2, 2, sub));
	}

	@Test
	public void shouldMult() {
		assertEquals(4, calculator.calculate(2, 2, mult));
	}

	@Test
	public void shouldDiv() {
		assertEquals(1, calculator.calculate(2, 2, div));
	}

	@Test
	public void shouldNotDiv() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate(2, 0, div));
	}

	@Test
	public void shouldPow() {
		assertEquals(4, calculator.calculate(2, 2, pow));
	}

	@Test
	public void shouldNotCalculateNullOperation() {
		assertThrows(IllegalArgumentException.class, () -> calculator.calculate(2, 2, null));
	}
}
