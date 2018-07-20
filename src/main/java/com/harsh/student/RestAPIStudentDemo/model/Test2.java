package com.harsh.student.RestAPIStudentDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="TEST2")
@Table(name="TEST2")
public class Test2 {
 private int idtest2;
 private String name;
 
 private Test1 objTest1;

 @Id
 @GeneratedValue
public int getIdtest2() {
	return idtest2;
}

public void setIdtest2(int idtest2) {
	this.idtest2 = idtest2;
}

@Column(name="name_test2",unique=true,nullable=false)
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@ManyToOne
@JoinColumn(name="TEST_ID1",insertable=false,updatable=false)
public Test1 getObjTest1() {
	return objTest1;
}

public void setObjTest1(Test1 objTest1) {
	this.objTest1 = objTest1;
}
 
}
