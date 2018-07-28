package com.harsh.student.RestAPIStudentDemo.service;

import org.springframework.stereotype.Service;

import com.harsh.student.RestAPIStudentDemo.model.TransactionTest;

@Service
public interface TransactionTestServiceInterface {

	public Integer InsertTransactionTestData();
	
	public TransactionTest UpdateTransactionData();
	
}
