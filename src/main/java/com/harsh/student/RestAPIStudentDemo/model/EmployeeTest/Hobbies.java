package com.harsh.student.RestAPIStudentDemo.model.EmployeeTest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="hobbies_tbl")
public class Hobbies {
	
	private Integer id;
	private String name;
	
	@Id
	@Column(name="id",nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result
	            + ((id == null) ? 0 : id.hashCode());
	   
	    result = prime * result + ((id == null) ? 0 : id.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Hobbies other = (Hobbies) obj;
	    if (id == null) {
	        if (other.id != null)
	            return false;
	    } else if (!id.equals(other.id))
	        return false;
	    
	   
	    return true;
	}
	
	//bery important for drp down to select
	@Override
	public String toString()
	{
		return String.valueOf(id);
		
	}

}
