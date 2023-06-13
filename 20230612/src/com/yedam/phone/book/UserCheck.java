package com.yedam.phone.book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import lombok.Data;

@Data
class User {
	String id;
	String pw;

	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

}

public class UserCheck {

	HashSet<User> userList = new HashSet<>();
	

	UserCheck() {
		readFromFile();
	}

	// id, passwd를 입력 받으면 true/false
	public boolean loginCheck(String id, String pw) {
		Iterator<User> iter = userList.iterator();
		while (iter.hasNext()) {
			User user = iter.next();
			if (user.id.equals(id) && user.pw.equals(pw)) {
				return true;
			}
		}

		return false;
	}

	public void readFromFile() {
		// c:/temp/userList.txt

		try {
			FileReader fr = new FileReader("C:/temp/userList.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine(); // user1 1111
				if (str == null) {
					break;
				}
				String[] record = str.split(" ");
				userList.add(new User(record[0], record[1]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			InputStream is = new FileInputStream("c:/temp/userList.txt");
//			InputStreamReader isr = new InputStreamReader(is);
//			char[] buf = new char[200];
//			isr.read(buf);
//			String check = scn.nextLine();
//			String str = new String(buf);
//			String[] strAry = str.split("\n");
//			for(String login : strAry) {
//				String[] arrst = login.split(" ");
//				if(arrst[0].equals(check)) {
//					
//				}
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}
}
