package com.harsh.student.RestAPIStudentDemo.model;


public class PhoneNumberCustom {
	
private long id;
private String phoneNumber;

public  PhoneNumberCustom(long id ,String phoneNumber )
{
	this.id=id;
	this.phoneNumber=phoneNumber;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

}
