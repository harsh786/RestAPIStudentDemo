package com.harsh.student.RestAPIStudentDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="STUDENT_DETAILS2")
@Table(name="STUDENT_DETAILS2")
public class StudentDetails2 {

	private long Id;
	private String Name;
	
	private Student objStudent2;
	
	
	
	
	
	
	
	@javax.persistence.Id
	@GeneratedValue
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID",referencedColumnName="STUDENT_ID")
	@MapsId
	public Student getObjStudent2() {
		return objStudent2;
	}
	public void setObjStudent2(Student objStudent2) {
		this.objStudent2 = objStudent2;
	}
	
	
	
	
}