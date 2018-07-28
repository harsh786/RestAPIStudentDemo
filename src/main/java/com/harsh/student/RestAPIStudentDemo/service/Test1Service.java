package com.harsh.student.RestAPIStudentDemo.service;

import javax.transaction.Transactional;

public interface Test1Service {
	@Transactional
	public boolean InsertDetailsTest1AndTest2();
	@Transactional
	public	boolean InsertDetailsTest1AndTest2AnotherTran();
}
