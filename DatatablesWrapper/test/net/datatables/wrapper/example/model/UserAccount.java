package net.datatables.wrapper.example.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import net.datatables.wrapper.annotation.AoColumn;

public class UserAccount {
	@AoColumn(sTitle = "User ID")
	private int userId;
	
	@AoColumn(sTitle = "Username")
	private String username;
	
	@AoColumn(sTitle = "Create Date")
	private Date createDate;
	
	@JsonIgnore  //We don't want the user password will be sent to table.
	private String password;
	
	
	
	
	public UserAccount(int userId, String username, Date createDate,
			String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.createDate = createDate;
		this.password = password;
	}
	
	// --setters and getters
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
