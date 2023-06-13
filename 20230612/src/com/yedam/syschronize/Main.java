package com.yedam.syschronize;

public class Main {
	public static void main(String[] args) {
		Calculator cal = new Calculator(); // memory.
		
		User1 user1 = new User1(); // memory = 100;
		user1.setCalculator(cal);
		user1.start(); // 쓰레드 시작
		
		User2 user2 = new User2(); // memory = 200;
		user2.setCalculator(cal);
		user2.start(); // 쓰레드 시작
	}
}
