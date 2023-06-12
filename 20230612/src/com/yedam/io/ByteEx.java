package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteEx {
	public static void main(String[] args) {
		// 입력(InputStream) -> 출력.(OutPutStream).
		try {
			FileInputStream fis = new FileInputStream("c:/temp/VSCodeUserSetup-x64-1.78.0.exe");
			FileOutputStream fos = new FileOutputStream("c:/temp/copy.exe");
			
			byte[] bytes = new byte[100];
			while (true) {
				int readInt = fis.read(bytes);
				System.out.println(readInt);
				if (readInt == -1) {
					break;
				}

				fos.write(bytes);

			}
			fis.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}

	public static void read1() {
		try {
			InputStream is = new FileInputStream("c:/temp/data1.dat");
			while (true) {
				int readInt = is.read();
				if (readInt == -1) {
					break;
				}
				System.out.println(readInt);

			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void write1() {
		// 출력스트림. 외부파일에 저장.
		try {
			OutputStream os = new FileOutputStream("c:/temp/data1.dat");
			byte a = 10;
			byte b = 20;
			os.write(a);
			os.write(b);
			os.flush(); // 캐시정보출 후 비우기
			os.close(); // 리소스 화누언.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
