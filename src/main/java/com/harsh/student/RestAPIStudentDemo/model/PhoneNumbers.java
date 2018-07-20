package com.harsh.student.RestAPIStudentDemo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity(name="PHONE_NUMBERS_TBL")
@Table(name="PHONE_NUMBERS_TBL")
//it gives serialziable exception if you not imlemen it when jackson is desrializable in rest api
public class PhoneNumbers implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	@GeneratedValue
private long id;
private String phoneNumber;
@Version
private long version;


/*public void PhoneNumbers(long id,String phoneNumber)
{
	this.id=id;
	this.phoneNumber=phoneNumber;
}*/
public long getVersion() {
	return version;
}
public void setVersion(long version) {
	this.version = version;
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

/*@JsonIgnore*/
@ManyToOne(cascade=CascadeType.ALL)
/*@JoinColumn(name="STUDENT_ID",referencedColumnName="STUDENT_ID",insertable=false,updatable=false,nullable=false)*/
@JoinColumn(name="STUDENT_ID",referencedColumnName="STUDENT_ID",nullable=false)
private Student objStudent;

public Student getObjStudent() {
	return objStudent;
}
public void setObjStudent(Student objStudent) {
	this.objStudent = objStudent;
}


}
