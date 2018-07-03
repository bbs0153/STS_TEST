package com.bit.vo;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {

	private String id;
	private String name;
	private int age;
	private String addr;
	private String fname;
	private MultipartFile uploadFile;

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String name, int age, String addr, String fname) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.fname = fname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

}
