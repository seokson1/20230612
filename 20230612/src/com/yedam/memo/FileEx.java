package com.yedam.memo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileEx {
	public static void main(String[] args) {

		try {
			InputStream is = new FileInputStream("src/com/yedam/memo/MemoApp.java");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String str = "";

			while ((str = br.readLine()) != null) { // readLind 한줄씩 읽어서 넣기.
				System.out.println(str);
			}
			br.close();
			isr.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		try {
//			Reader is = new FileReader("src/com/yedam/memo/sample.txt");
//
//			char[] buf = new char[100];
//
//			is.read(buf);
//			System.out.println(buf);
//			is.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("end of prog.");
	}

	public void method1() {
		try {
			FileOutputStream fos = new FileOutputStream("src/com/yedam/memo/sample.txt");
			fos.write(10);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
