package com.yedam.phone.book;

public class PhoneUnivInfo extends PhoneInfo {

	private String major;
	private int year;

	public PhoneUnivInfo(String name, String phoneNymber, String major, int year) {
		super(name, phoneNymber);
		this.major = major;
		this.year = year;
	}

	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("major: " + major);
		System.out.println("year: " + year);
	}

	@Override
	public String toString() {
		return INPUT_SELECT.UNIV + "," + this.getName() + "," + this.getPhoneNymber() + 
				"," + major + "," + year + "\n";
	}
}
