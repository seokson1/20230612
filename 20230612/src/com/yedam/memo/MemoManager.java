package com.yedam.memo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {
	List<Memo> storage = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	public MemoManager() {
		readFromFile();
	}

	// 등록.
	public void inputData() {
		System.out.print("번호>");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜>");
		String date = scn.nextLine();
		System.out.print("내용>");
		String content = scn.nextLine();

		storage.add(new Memo(no, date, content));
	}

	// 조회.
	public void searchData() {
		System.out.print("날짜> ");
		String date = scn.nextLine();
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (date.equals(storage.get(i).getDate())) {
				System.out.println(storage.get(i));
				isYn = true;
			}
		}
		if (!isYn) {
			System.out.println("해당 날짜의 메모가 없습니다.");
		}
	}

	// 삭제
	public void deleteData() {
		System.out.print("번호> ");
		int no = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (no == storage.get(i).getNo()) {
				storage.remove(i);
				isYn = true;
			}
		}
		if(!isYn) {
			System.out.println("해당 번호가 없습니다.");
		}
	}

	// 실행..
	public void readFromFile() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/memobook.dat");
			try {
				ObjectInputStream ois = new ObjectInputStream(fis);

				storage = (List<Memo>) ois.readObject();
				ois.close();
				fis.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("계속 진행하세요.");
		}
	}

	// 파일저장. - 종료
	public void storeToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/memobook.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(storage);
			oos.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
