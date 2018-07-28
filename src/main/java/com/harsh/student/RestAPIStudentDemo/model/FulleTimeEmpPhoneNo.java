package com.harsh.student.RestAPIStudentDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity(name="FulleTimeEmpPhoneNo")
@Table(name="FulleTimeEmpPhoneNo")
@Audited
public class FulleTimeEmpPhoneNo {

	private long id;
	private String number;
	
	
	private FullTimeEmployee objFullTimeEmployee;
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@ManyToOne 
	@JoinColumn(name="employeeid",referencedColumnName="id",insertable=true,updatable=true)
	public FullTimeEmployee getObjFullTimeEmployee() {
		return objFullTimeEmployee;
	}

	public void setObjFullTimeEmployee(FullTimeEmployee objFullTimeEmployee) {
		this.objFullTimeEmployee = objFullTimeEmployee;
	}
	
}
