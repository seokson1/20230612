package com.yedam.syschronize;

//User1 쓰레드 : calculaotor memory= 100;
public class User1 extends Thread {
	
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMenoty(100);
	}
}
