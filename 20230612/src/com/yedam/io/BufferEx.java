package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferEx {
	public static void main(String[] args) {
		try {
			bufferStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}

	public static void bufferStream() throws IOException {
		// 읽고 쓰고 버퍼 성능 향상.
		FileInputStream fis = new FileInputStream("c:/temp/VSCodeUserSetup-x64-1.78.0.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("c:/temp/copy2.exe");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int readBuf = 0;
		while ((readBuf = bis.read()) != -1) {
//			readBuf = bis.read(); // 버퍼에 저장.
//			if(readBuf == -1) {
//				break;
//			}
			bos.write(readBuf);

		}
		bos.flush();
		bos.close();
		fos.close();
		bis.close();
		fis.close();

	}
}
