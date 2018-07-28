package com.harsh.student.RestAPIStudentDemo.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import com.harsh.student.RestAPIStudentDemo.LoggedUserGenerator;

@MappedSuperclass
@Audited
public class Employee {

	
    public long version;
	
	
	public Date rowInsertionTime;
	
	
	
	public Date rowUpdationTime;
	
	public String createdBy;
	
	public String updatedBy;
	
	

	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRowInsertionTime() {
		return rowInsertionTime;
	}

	public void setRowInsertionTime(Date rowInsertionTime) {
		this.rowInsertionTime = rowInsertionTime;
	}
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRowUpdationTime() {
		return rowUpdationTime;
	}

	public void setRowUpdationTime(Date rowUpdationTime) {
		this.rowUpdationTime = rowUpdationTime;
	}

	 @GeneratorType(
		        type = LoggedUserGenerator.class,
		        when = GenerationTime.INSERT
		    )
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	 @GeneratorType(
		        type = LoggedUserGenerator.class,
		        when = GenerationTime.ALWAYS
		    )
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
