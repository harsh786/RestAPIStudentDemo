package com.harsh.student.RestAPIStudentDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties("studentProp")
@PropertySource("classpath:test.properties")
public class TestPropertiesConfig {
 
	private students objstudents;
	
	public static class students
	{
		private String name;
		private int id;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		
	}

	public students getObjstudents() {
		return objstudents;
	}

	public void setObjstudents(students objstudents) {
		this.objstudents = objstudents;
	}
}
