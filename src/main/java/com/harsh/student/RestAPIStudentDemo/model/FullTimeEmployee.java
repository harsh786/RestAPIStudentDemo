package com.harsh.student.RestAPIStudentDemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;


@Table(name="FullTimeEmployee")
@Entity(name="FullTimeEmployee")
@Audited
public class FullTimeEmployee extends Employee implements Serializable{
	 public static enum State {
		    ACTIVE(3,"active"),DELEETED(2,"deleted"),SUSPENDED(1,"suspended");
		 
		 private int statusId;
		 private String name;
		 
		 State(int statusId,String name)
		 {
			 this.statusId=statusId;
			 this.name=name;
		 }
		public int getStatusId() {
			return statusId;
		}
		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		 
		  }
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private long Salary;
	private List<FulleTimeEmpPhoneNo>ls=new ArrayList<FulleTimeEmpPhoneNo>();
	
	 private State status;
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return Salary;
	}
	public void setSalary(long salary) {
		Salary = salary;
	}
	@OneToMany(mappedBy="objFullTimeEmployee",cascade=CascadeType.ALL)
    @Column(insertable=true)
	public List<FulleTimeEmpPhoneNo> getLs() {
		return ls;
	}
	public void setLs(List<FulleTimeEmpPhoneNo> ls) {
		this.ls = ls;
	}
	
	@Enumerated(EnumType.ORDINAL)
	public State getStatus() {
		return status;
	}
	public void setStatus(State status) {
		this.status = status;
	}
	
}
