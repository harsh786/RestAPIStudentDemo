package com.harsh.student.RestAPIStudentDemo.controller.EmployeeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.student.RestAPIStudentDemo.model.TransactionTest;
import com.harsh.student.RestAPIStudentDemo.service.TransactionTestServiceInterface;

@RestController
public class TransactionTestController {
	@Autowired
	private TransactionTestServiceInterface objTransactionTestServiceInterface;

	
	public TransactionTestServiceInterface getObjTransactionTestServiceInterface() {
		return objTransactionTestServiceInterface;
	}

	public void setObjTransactionTestServiceInterface(TransactionTestServiceInterface objTransactionTestServiceInterface) {
		this.objTransactionTestServiceInterface = objTransactionTestServiceInterface;
	}
	
	@RequestMapping(value="/txn")
	public Integer InsertTransactionData() {
	return 	objTransactionTestServiceInterface.InsertTransactionTestData();
		
	}
	

	@RequestMapping(value="/txnu")
	public TransactionTest UpdateTransactionData() {
	
		return objTransactionTestServiceInterface.UpdateTransactionData();
	}
}
