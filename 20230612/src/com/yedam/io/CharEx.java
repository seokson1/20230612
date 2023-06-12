package com.yedam.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharEx {
	public static void main(String[] args) {
		try {
			read1();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}

	public static void read1() throws IOException {
		FileReader fr = new FileReader("c:/temp/addr.txt");
		char[] buf = new char[10];
		while (true) {
			int readInt = fr.read(buf);
			if (readInt == -1) {
				break;
			}
			for (int i = 0; i < readInt; i++) {
				System.out.print((char) buf[i]);
			}

		}
		fr.close();
	}

	public static void write1() throws IOException {
		FileWriter fr = new FileWriter("c:/temp/addr.txt");
		Scanner scn = new Scanner(System.in);
		System.out.print("입력(종료 시 quit)>");
		String input = "";

		while (true) {
			input = scn.nextLine();
			if (input.equals("quit")) {
				break;
			}
			fr.write(input + "\n");
		}
		fr.flush();
		fr.close();
		scn.close();
	}
}
