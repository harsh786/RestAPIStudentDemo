package com.harsh.student.RestAPIStudentDemo.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.harsh.student.RestAPIStudentDemo.Repository.Test1Repo;
import com.harsh.student.RestAPIStudentDemo.Repository.Test2Repo;
import com.harsh.student.RestAPIStudentDemo.model.Test1;
import com.harsh.student.RestAPIStudentDemo.model.Test2;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("Test1ServiceImpl")
public class Test1ServiceImpl implements Test1Service {
	@Autowired
 private Test1Repo objTest1Repo;
	
	@Autowired
	private Test2ServiceImpl Obj;
 
public Test2ServiceImpl getObj() {
		return Obj;
	}
	public void setObj(Test2ServiceImpl obj) {
		Obj = obj;
	}
public Test1Repo getObjTest1Repo() {
	return objTest1Repo;
}
public void setObjTest1Repo(Test1Repo objTest1Repo) {
	this.objTest1Repo = objTest1Repo;
}

//casacded enties are rolback as they are in one transaction
@Override
@Transactional(propagation=Propagation.REQUIRED)
public boolean InsertDetailsTest1AndTest2()
{
	boolean status=true;

	try
	{
		Test1 objTest1=new Test1();
		objTest1.setName("harsh");
		Test2 objTest2=new Test2();
		objTest2.setName("harshtest2");
		Test2 objTest21=new Test2();
		objTest21.setName("harshtest2");
		
		objTest1.getObjTest2().add(objTest2);
		objTest1.getObjTest2().add(objTest21);
		objTest1Repo.save(objTest1);
	}
	catch(Exception ex)
	{
		status=false;
	}
return status;
}

// if test2 data is of requires new then it will not rollback if test2 data is of require then it rollback
//if you create manuaaly then it will not rollback whethers it is of test2 requires
//so better to create bean using DI
//same class method in transaction part is not act as part of tranaction
@Override
@Transactional(propagation=Propagation.REQUIRED)
public boolean InsertDetailsTest1AndTest2AnotherTran()
{
	boolean status=true;

	try
	{
		Test1 objTest1=new Test1();
		objTest1.setName("harsh5");
		
		
		//objTest1.getObjTest2().add(objTest2);
				//objTest1.getObjTest2().add(objTest21);
				objTest1Repo.save(objTest1);
				
				Obj.InsertTest2Data();
	}
	catch(Exception ex)
	{
		status=false;
	}
return status;
}

public void FetchAssosciatedEntities()
{
	
}
}
