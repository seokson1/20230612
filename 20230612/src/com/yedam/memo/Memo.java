package com.yedam.memo;

import java.io.Serializable;

// 메모번호, 날짜, 내용.
public class Memo implements Serializable {

	private int no;
	private String date;
	private String content;

	public Memo(int no, String date, String content) {
		super();
		this.no = no;
		this.date = date;
		this.content = content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Memo [no=" + no + ", date=" + date + ", content=" + content + "]";
	}

}
