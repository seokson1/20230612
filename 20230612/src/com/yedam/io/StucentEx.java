package com.yedam.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StucentEx {
	public static void main(String[] args) throws IOException {
		// c:/temp/students.txt 학생의 점수 평균하기.
		// 최고점수의 학생이름과 최고점수를 출력.
		try {
			method2();
		} catch (Exception e) {

		}
//		System.out.println("평균: 82.");
//		System.out.println("최고점수: 90, 학생은 김인수.");
		System.out.println();
		System.out.println("end of prog.");
	}

	public static void method2() throws IOException {
		InputStream is = new FileInputStream("c:/temp/students.txt");
		InputStreamReader isr = new InputStreamReader(is); // 바이트 -> char 보조스트림
		char[] buf = new char[200];
		isr.read(buf); // read 입력스트림 통해서 buf 저장.

		String str = new String(buf);
		// System.out.println(str);
		String[] strAry = str.split("\n");
		int max =0;
		for (String student : strAry) {
			if (student != null) {
				String[] std = student.split(" ");
				System.out.printf("학생번호 %s, 이름 %s, 점수%s", std[0], std[1], std[2]);
			}
		}

	}

	public static void method1() throws IOException {
		Scanner scn = new Scanner(new File("c:/temp/students.txt"));
		String name = "";
		int sum = 0, cnt = 0, maxScore = 0;
		double avg = 0;
		while (true) {
			String values;
			try {
				values = scn.nextLine(); // 학생 정보 1라인 읽어옴.
			} catch (NoSuchElementException e) {
				break;
			}
			String[] valAry = values.split(" ");
			sum += Integer.parseInt(valAry[2]);
			cnt++;
			if (maxScore < Integer.parseInt(valAry[2])) {
				maxScore = Integer.parseInt(valAry[2]);
				name = valAry[1];
			}
		}
		avg = (double) sum / cnt;
		System.out.printf("평균점수: %.2f \n", avg);
		System.out.printf("최고점수 %d, 학생이름 %s \n", maxScore, name);
	}

}
