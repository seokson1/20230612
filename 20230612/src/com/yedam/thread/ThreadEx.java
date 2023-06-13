package com.yedam.thread;

import java.awt.Toolkit;

public class ThreadEx {
	public static void main(String[] args) {
		//1. Runnable 인터페이스 구현 클래스.
//		Thread thread = new Thread(new BeepTask());
		
		//2. Runnable 인터페이스 익명 구현 객체로 생성.
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
//		thread.start();
		
		//3. Thread 클래스를 상속받은 하위 클래스.
		thread = new BeepThread();
		thread.start();

		// 화면 : 내용출력. 소리 출력.
		for (int i = 0; i < 5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
