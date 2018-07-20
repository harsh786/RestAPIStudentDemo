package com.harsh.student.RestAPIStudentDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.harsh.student.RestAPIStudentDemo.Repository.Test2Repo;
import com.harsh.student.RestAPIStudentDemo.model.Test2;

@Service("Test2ServiceImpl")
public class Test2ServiceImpl {
	@Autowired
	 private Test2Repo objTest2Repo;
	public Test2Repo getObjTest2Repo() {
		return objTest2Repo;
	}
	public void setObjTest2Repo(Test2Repo objTest2Repo) {
		this.objTest2Repo = objTest2Repo;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void InsertTest2Data()
	{
		try
		{
			Test2 objTest2=new Test2();
			objTest2.setName("harshtest2");
			Test2 objTest21=new Test2();
			objTest21.setName("harshtest2");
			objTest2Repo.save(objTest2);
			objTest2Repo.save(objTest21);
		}catch(Exception ex)
		{
			
		}
		
		
		
		
	}
}
