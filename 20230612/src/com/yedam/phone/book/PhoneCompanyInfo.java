package com.yedam.phone.book;

public class PhoneCompanyInfo extends PhoneInfo {

	private String company;

	public PhoneCompanyInfo(String name, String phoneNymber, String company) {
		super(name, phoneNymber);
		this.company = company;
	}

	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company: " + company);
	}

	@Override
	public String toString() {
		return INPUT_SELECT.COMPANY + "," + this.getName() + "," + this.getPhoneNymber() + 
				"," + company + "\n";
	}
}
