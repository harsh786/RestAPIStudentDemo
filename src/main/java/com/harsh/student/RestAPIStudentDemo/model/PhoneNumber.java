package com.harsh.student.RestAPIStudentDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.ManyToAny;

@Entity(name="PHONE_NUMBER_TBL")
@Table(name="PHONE_NUMBER_TBL")
public class PhoneNumber {

	@javax.persistence.Id
	@GeneratedValue
private long Id;
private String PhoneNumber;
@Version
private long version;

public long getVersion() {
	return version;
}
public void setVersion(long version) {
	this.version = version;
}
public long getId() {
	return Id;
}
public void setId(long id) {
	Id = id;
}
public String getPhoneNumber() {
	return PhoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	PhoneNumber = phoneNumber;
}


/*private Student objStudent;

@ManyToOne
@JoinColumn(name="STUDENT_ID",referencedColumnName="STUDENT_ID")
public Student getObjStudent() {
	return objStudent;
}
public void setObjStudent(Student objStudent) {
	this.objStudent = objStudent;
}*/

}
