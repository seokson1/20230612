package com.yedam.phone.book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

// 추가, 조회, 삭제, 종료(저장) - file
public class PhoneBookManager {

	// 친구이름 Set 컬렉션 사용 - 친구이름 중복허용 하지 않음.
	HashSet<PhoneInfo> infoStorge = new HashSet<>();
	File dataFile = new File("c:/temp/phonebook.txt");
	File dataStream = new File("c:/temp/phonebook.dat");

	private static PhoneBookManager instance;

	private PhoneBookManager() {
		readFromFile(); // 저장된 정보를 set컬렉션에 담아줌. 초기화.
		readFromStream();
	}

	public static PhoneBookManager getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager();
		}
		return instance;
	}

	// 등록.
	public void inputData() throws MenuChoiceException {
		System.out.println("전화번호 구분");
		System.out.println("1.일반 | 2.대학 | 3.회사");
		System.out.print("선택> ");

		PhoneInfo info = null;
		int menu = MenuViewer.scn.nextInt();
		MenuViewer.scn.nextLine();

		if (menu < INPUT_SELECT.NORMAL || menu > INPUT_SELECT.COMPANY) {
			throw new MenuChoiceException(menu);
		}
		switch (menu) {
		case INPUT_SELECT.NORMAL:
			info = readFriendInfo();
			break;
		case INPUT_SELECT.UNIV:
			info = readUnivFriendInfo();
			break;
		case INPUT_SELECT.COMPANY:
			info = readCompanyFriendInfo();
			break;

		}
		boolean isAdded = infoStorge.add(info); // 중복값 false, 정상 true
		if (isAdded) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록오류");
		}

	}

	// 친구등록 메소드.
	private PhoneInfo readFriendInfo() {
		System.out.print("이름> ");
		String name = MenuViewer.scn.nextLine();
		System.out.print("전화번호> ");
		String phone = MenuViewer.scn.nextLine();
		return new PhoneInfo(name, phone);
	}

	private PhoneInfo readUnivFriendInfo() {
		System.out.print("이름> ");
		String name = MenuViewer.scn.nextLine();
		System.out.print("전화번호> ");
		String phone = MenuViewer.scn.nextLine();
		System.out.print("전공> ");
		String major = MenuViewer.scn.nextLine();
		System.out.print("학년> ");
		int year = MenuViewer.scn.nextInt();
		MenuViewer.scn.nextLine();
		return new PhoneUnivInfo(name, phone, major, year);
	}

	private PhoneInfo readCompanyFriendInfo() {
		System.out.print("이름> ");
		String name = MenuViewer.scn.nextLine();
		System.out.print("전화번호> ");
		String phone = MenuViewer.scn.nextLine();
		System.out.print("회사명> ");
		String company = MenuViewer.scn.nextLine();

		return new PhoneCompanyInfo(name, phone, company);
	}

	// 종료. storeToStream() => ObjectOutputStream : Serializable (저장하는 객체 - 구현 해야됨.)
	public void storeToStream() {
		System.out.println("종료합니다.");
		try {
			FileOutputStream fw = new FileOutputStream(dataStream);
			ObjectOutputStream oos = new ObjectOutputStream(fw);

			oos.writeObject(infoStorge);

			oos.flush();
			oos.close();
			fw.flush();
			fw.close();
			System.out.println("저장완료.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void storeToFile() {
		System.out.println("종료합니다.");
		try {
			FileWriter fw = new FileWriter(dataFile);
			Iterator<PhoneInfo> iter = infoStorge.iterator();
			while (iter.hasNext()) {
				fw.write(iter.next().toString()); // 이름, 연락처, 전공 학년
			}
			fw.flush();
			fw.close();
			System.out.println("저장완료.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일읽기. readFromStream(); => ObjectInputStream();
	public void readFromStream() {
		if (!dataFile.exists()) {
			return;
		}
		try {
			FileInputStream fis = new FileInputStream(dataStream);
			ObjectInputStream ois = new ObjectInputStream(fis);

			infoStorge = (HashSet<PhoneInfo>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		if (!dataFile.exists()) {
			return;
		}
		try {
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);

			String str = "";
			PhoneInfo info = null;
			while ((str = br.readLine()) != null) {
				String[] record = str.split(",");
				int kind = Integer.parseInt(record[0]);
				switch (kind) {
				case INPUT_SELECT.NORMAL:
					info = new PhoneInfo(record[1], record[2]);
					break;
				case INPUT_SELECT.UNIV:
					info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
					break;
				case INPUT_SELECT.COMPANY:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
					break;
				}
				infoStorge.add(info);
			}

			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 삭제.
	public void deleteData() {
		System.out.print("이름> ");
		String name = MenuViewer.scn.nextLine();

		Iterator<PhoneInfo> iter = infoStorge.iterator();
		while (iter.hasNext()) {
			PhoneInfo curr = iter.next();
			if (curr.getName().equals(name)) {
				iter.remove();
				System.out.println("삭제완료.");
				return;
			}
		}
		System.out.println("삭제할 이름이 없습니다.");
	}

	// 검색
	public void searchData() {
		System.out.print("이름> ");
		String name = MenuViewer.scn.next();

		PhoneInfo info = search(name);
		if (info == null) {
			System.out.println("찾는 이름이 없습니다.");
		} else {
			info.showPhoneInfo();
		}
	}

	public PhoneInfo search(String name) {
		Iterator<PhoneInfo> iter = infoStorge.iterator();
		while (iter.hasNext()) {
			PhoneInfo curItem = iter.next();
			if (curItem.getName().equals(name)) {
				return curItem;
			}
		}
		return null;
	}
}
