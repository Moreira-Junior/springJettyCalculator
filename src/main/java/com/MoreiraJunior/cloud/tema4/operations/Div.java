package com.MoreiraJunior.cloud.tema4.operations;

public class Div implements Operation{

	private double number1;
	private double number2;
	private double result;

	@Override
	public double calculate() {
		this.result = this.number1 / this.number2;
		return result;
	}

	@Override
	public void setNumber1(double x) {
		this.number1 = x;
	}

	@Override
	public double getNumber1() {
		return this.number1;
	}

	@Override
	public void setNumber2(double y) {
		this.number2 = y;
	}

	@Override
	public double getNumber2() {
		return this.number2;
	}

	@Override
	public double getResult() {
		return this.result;
	}

	@Override
	public String toString() {
		return "Div [number1=" + number1 + ", number2=" + number2 + ", result=" + result + "]";
	}
}
