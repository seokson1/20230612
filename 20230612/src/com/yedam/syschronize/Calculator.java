package com.yedam.syschronize;

//User1, User2 작업쓰레드.
public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public void setMenoty(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("쓰레드명: " + 
				Thread.currentThread().getName() + " : " + memory);
	}
}
