package com.harsh.student.RestAPIStudentDemo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AEntityPrimaryKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer Keys1;
	
	private String Name;

	public int getKeys1() {
		return Keys1;
	}

	public void setKeys1(int key) {
		Keys1 = key;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AEntityPrimaryKey that = (AEntityPrimaryKey) o;

        if (Integer.compare(Keys1, that.Keys1)!=0) return false;
        return Name.equals(that.Name);
    }

    @Override
    public int hashCode() {
        int result = Keys1.hashCode();
        result = 31 * result + Name.hashCode();
        return result;
    }
}
