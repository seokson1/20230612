package com.yedam.memo;

import java.util.Scanner;

public class MempApp {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int choice;

		MemoManager app = new MemoManager();

		while (true) {
			try {
				System.out.println("1.등록 | 2.검색 | 3.삭제 | 4.종료");
				System.out.print("선택> ");
				choice = Integer.parseInt(scn.nextLine());

				switch (choice) {
				case MENU.INTERT:
					app.inputData();
					break;
				case MENU.SEARCH:
					app.searchData();
					break;
				case MENU.DELETE:
					app.deleteData();
					break;
				case MENU.EXIT:
					app.storeToFile();
					throw new ExitException(); // 종료처리
				}
			} catch (ExitException e) {
				break;
			}
		}
		System.out.println("end of prog.");
		scn.close();

	}
}
