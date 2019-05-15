package com.cafe24.mysite.vo;

public class GuestbookVo {
	private Long no;
	private String name;
	private String passsword;
	private String contents;
	private String regDate;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) { 
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "GuestbookVo [no=" + no + ", name=" + name + ", passsword=" + passsword + ", contents=" + contents
				+ ", regDate=" + regDate + "]";
	}
	
}
