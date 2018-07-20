package com.harsh.student.RestAPIStudentDemo.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	 @NotNull
	    @Size(min=3, max=5)
 private String UserName;
	 @NotNull
	    @Size(min=4, max=30)
 private String Password;
 private boolean isError;
 private String errorMsg;
 
public boolean isIsError() {
	return isError;
}
public void setIsError(boolean isError1) {
	isError = isError1;
}
public String getErrorMsg() {
	return errorMsg;
}
public void setErrorMsg(String errorMsg1) {
	errorMsg = errorMsg1;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
 
}
