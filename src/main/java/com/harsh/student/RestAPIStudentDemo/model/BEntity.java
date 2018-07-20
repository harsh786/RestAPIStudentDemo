package com.harsh.student.RestAPIStudentDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/*
 * In these we make composite in entity A and then do manytoone in Entity B and in B (Keys1 and name which are primary ke of A are alo Composite 
 * unique in B and alsoas foreign key of B .
 * if u wnat to do onetoon mapping and share same PK of and B then use MapsId
 * In Manytone with joincolumn you also want as id that foreign key then use primarykeyjoincolumn
 * 
 */
@Entity(name="B_ENTITY")
@Table(name="B_ENTITY",uniqueConstraints = {@UniqueConstraint(columnNames = { "Keys1", "Name" }) })
public class BEntity {


	private int id;
	
	@Id
	@GeneratedValue
 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

private String DummyColumn;
 
 private AEntity objAEntity;

public String getDummyColumn() {
	return DummyColumn;
}

public void setDummyColumn(String dummyColumn) {
	DummyColumn = dummyColumn;
}


@ManyToOne
@JoinColumns(value = {@JoinColumn(name="Keys1",referencedColumnName="Keys1"),
		@JoinColumn(name="Name",referencedColumnName="Name")
})
public AEntity getObjAEntity() {
	return objAEntity;
}

public void setObjAEntity(AEntity objAEntity) {
	this.objAEntity = objAEntity;
}
 
}
