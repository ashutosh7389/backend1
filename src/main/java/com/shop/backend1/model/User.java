package com.shop.backend1.model;

 import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name = "User")
public class User {
	@Id
	@Column(name="UserId")
	@GeneratedValue
	private int userId;
	private String userName;

	private String email;
private String password;
private String address;


private int contact;

private int zipcode;
 private boolean enabled;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public int getContact() {
	return contact;
}
public void setContact(int string) {
	this.contact = string;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}