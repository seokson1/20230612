package com.yedam.phone.book;

import java.util.Scanner;

public class MenuViewer {
	public static Scanner scn = new Scanner(System.in);
	public static void showMenu()	{
		System.out.println("전화번호관리: ");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("3. 삭제");
		System.out.println("4. 종료");
	}
}
