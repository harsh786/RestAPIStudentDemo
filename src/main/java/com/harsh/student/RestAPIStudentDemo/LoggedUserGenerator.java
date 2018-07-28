package com.harsh.student.RestAPIStudentDemo;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

public class LoggedUserGenerator
implements ValueGenerator<String> {

	@Override
	public String generateValue(Session session, Object owner) {
		// TODO Auto-generated method stub
		return "HARSH_KUMAR";
	}


}