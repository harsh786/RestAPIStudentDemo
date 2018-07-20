package com.harsh.student.RestAPIStudentDemo.model;

import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.qos.logback.core.spi.AppenderAttachableImpl;

@Entity(name="A_ENTITY")
@Table(name="A_ENTITY")
public class AEntity {

	
	private AEntityPrimaryKey objAEntityPrimaryKey;
	
	
	private String DummyColumn1;
	private Set<BEntity> setBEntity;
	
	@EmbeddedId
	public AEntityPrimaryKey getObjAEntityPrimaryKey() {
		return objAEntityPrimaryKey;
	}
	public void setObjAEntityPrimaryKey(AEntityPrimaryKey objAEntityPrimaryKey) {
		this.objAEntityPrimaryKey = objAEntityPrimaryKey;
	}
	public String getDummyColumn1() {
		return DummyColumn1;
	}
	public void setDummyColumn1(String dummyColumn1) {
		DummyColumn1 = dummyColumn1;
	}
	
	@OneToMany(mappedBy="objAEntity")
	public Set<BEntity> getSetBEntity() {
		return setBEntity;
	}
	public void setSetBEntity(Set<BEntity> setBEntity) {
		this.setBEntity = setBEntity;
	}
	
	
}
