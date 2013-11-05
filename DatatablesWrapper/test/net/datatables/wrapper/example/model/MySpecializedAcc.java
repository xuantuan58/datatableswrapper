package net.datatables.wrapper.example.model;

import java.util.Date;


import net.datatables.wrapper.annotation.AoColumn;

public class MySpecializedAcc extends UserAccount {

	@AoColumn(sTitle="Contact Info")
	private String contact = "this is my contact";
	
	@AoColumn(sTitle="Account Name")
	private String username = "my new username";
	
	@AoColumn(sTitle = "Password")
	private String password = "sdfsdfsd";
	
	public MySpecializedAcc(int userId, String username, Date createDate,
			String password) {
		super(userId, username, createDate, password);
	}
	

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
