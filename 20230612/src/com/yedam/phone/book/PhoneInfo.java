package com.yedam.phone.book;

import java.io.Serializable;

import lombok.Data;

@Data
public class PhoneInfo implements Serializable {

	private String name;
	private String phoneNymber;

	public PhoneInfo(String name, String phoneNymber) {
		this.name = name;
		this.phoneNymber = phoneNymber;
	}

	public void showPhoneInfo() {
		System.out.println("name: " + name);
		System.out.println("phone: " + phoneNymber);
	}

	// 논리적 동일한 객체. 기능 필요 hashcode, equals 정의에 따라 다름.
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo info = (PhoneInfo) obj;
		if (info.name.compareTo(this.name) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return INPUT_SELECT.NORMAL + "," + name + "," + phoneNymber + "\n";
	}

}
