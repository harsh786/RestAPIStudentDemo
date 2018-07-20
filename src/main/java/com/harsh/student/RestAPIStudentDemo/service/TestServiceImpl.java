package com.harsh.student.RestAPIStudentDemo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.harsh.student.RestAPIStudentDemo.model.Student;

@Service("testService")
public class TestServiceImpl {

	public  TestServiceImpl()
	{
		
	}
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW) 
	public void SavePhoneNumber() {
		throw new RuntimeException("Rollback this transaction1111!");
		// TODO Auto-generated method stub
//		PhoneNumber ObjPhoneNumber=new PhoneNumber();
//		ObjPhoneNumber.setPhoneNumber("9582492891");
//		objStudent.getLsPhoneNumber().add(ObjPhoneNumber);
	}
}
