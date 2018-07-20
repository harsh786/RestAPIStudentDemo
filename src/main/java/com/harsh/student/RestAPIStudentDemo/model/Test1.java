package com.harsh.student.RestAPIStudentDemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="TEST1")
@Table(name="TEST1")
public class Test1 {
  private int id;
  private String name;
  private List<Test2> objTest2=new ArrayList<Test2>();
  
  


@Id
  @GeneratedValue
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Column(name="name_test1",unique=true,nullable=false)
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


@OneToMany(cascade=CascadeType.ALL,mappedBy="objTest1")
public List<Test2> getObjTest2() {
	return objTest2;
}
public void setObjTest2(List<Test2> objTest2) {
	this.objTest2 = objTest2;
}
}
