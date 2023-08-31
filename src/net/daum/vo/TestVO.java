package net.daum.vo;

import java.sql.Timestamp;

public class TestVO { //데이터 저장 Bean 클래스 (DTO, 자바 빈:Java bean)
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}
