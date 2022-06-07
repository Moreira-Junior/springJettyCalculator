package com.MoreiraJunior.cloud.tema4.appConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.MoreiraJunior.cloud.tema4.calculator.Calculator;
import com.MoreiraJunior.cloud.tema4.history.History;
import com.MoreiraJunior.cloud.tema4.operations.Div;
import com.MoreiraJunior.cloud.tema4.operations.Mult;
import com.MoreiraJunior.cloud.tema4.operations.Pow;
import com.MoreiraJunior.cloud.tema4.operations.Sub;
import com.MoreiraJunior.cloud.tema4.operations.Sum;

@Configuration
@ComponentScan("com.MoreiraJunior.cloud.tema1")
public class AppConfig {
	
	@Bean
	public Calculator createCalculator() {
		return new Calculator();
	}
	
	@Bean
	public History createHistory() {
		return new History();
	}
	
	@Bean
	@Scope("prototype")
	public Sum sum() {
		return new Sum();
	}
	
	@Bean
	@Scope("prototype")
	public Sub sub() {
		return new Sub();
	}
	
	@Bean
	@Scope("prototype")
	public Mult mult() {
		return new Mult();
	}
	
	@Bean
	@Scope("prototype")
	public Pow pow() {
		return new Pow();
	}
	
	@Bean
	@Scope("prototype")
	public Div div() {
		return new Div();
	}
}
