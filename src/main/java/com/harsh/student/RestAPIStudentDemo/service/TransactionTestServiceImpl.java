package com.harsh.student.RestAPIStudentDemo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.harsh.student.RestAPIStudentDemo.Repository.TransactionTestRepo;
import com.harsh.student.RestAPIStudentDemo.model.TransactionTest;

@Service
public class TransactionTestServiceImpl implements TransactionTestServiceInterface{
	@Autowired
	private TransactionTestRepo objTransactionTestRepo;
	
	public TransactionTestRepo getObjTransactionTestRepo() {
		return objTransactionTestRepo;
	}

	public void setObjTransactionTestRepo(TransactionTestRepo objTransactionTestRepo) {
		this.objTransactionTestRepo = objTransactionTestRepo;
	}

	@Override
	@Transactional
	public Integer InsertTransactionTestData() {
		// TODO Auto-generated method stub
		TransactionTest ObjTransactionTest=new TransactionTest();
		ObjTransactionTest.setAge(10);
		ObjTransactionTest.setName("harsh");
		ObjTransactionTest.setRollNo(11103022);
		return objTransactionTestRepo.save(ObjTransactionTest).getId();
	}

	/*
	 * (non-Javadoc)
	 * @see com.harsh.student.RestAPIStudentDemo.service.TransactionTestServiceInterface#UpdateTransactionData()
	 * what happen if you are using transaction
	 * 1.Evey insert update operation should be in transaction and modifying
	 * 2.If you fetch using id like findbyone then it immediatly cause select
	 * 3.if you again select by same id ten it will not fetchbeacse it is prsent in persistence context
	 * 4.If you change modification on fetched entity thn it do cause any sql statment until commit
	 * 5.But if inbetween after 4 point there is jpql and sql query in between transaction then it do the transaction 
	 * (like if slect on sql serer it show loading)
	 * Then on abobe exceuting jpql and sql query if you not use clear automatically then above all sql reuest 4 point and 5 point not update the
	 * persistence context or clear the persistence context then it must to do clear automatically after jpql or sql query then it will clear the persistence context 
	 * and again select the data which is come from db not from persistence context.
	 * 
	 * 
	 */
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public TransactionTest UpdateTransactionData() {
		Integer id=2;
		TransactionTest ObjTransactionTest=null;
		TransactionTest ObjTransactionTestResponse=null;
		ObjTransactionTest=objTransactionTestRepo.findOne(id);
		ObjTransactionTestResponse=objTransactionTestRepo.findOne(id);
	
		ObjTransactionTest.setAge(70);//it will flush on commit if clear automatically not use for next jpql
		
		objTransactionTestRepo.UpdateAgeOfTranactionTestNativeJpql(id);//without clear automatically it also hold the db transaction and not commit the data or flush the data
		objTransactionTestRepo.UpdateNameOfTranactionTestNativeJpql(id);//with clear automatcially it alos hold the db transaction and flush the data immedtaly ..if after it
		//some do find ten it give tis above flus data ...which may b rollback after failure
		//ObjTransactionTestResponse=objTransactionTestRepo.findOne(id);//if above two jpql not use clear autmatically then on this find not give the updated data
		//as it is presistence context not sync with db. beacuse it will hold the transaction and flush on commit after last statement...
		//if you want to see the differnce then  you can check by removing clearautomatically
		
		ObjTransactionTestResponse=objTransactionTestRepo.GetDataFromId(id);
		// int a=1/0;
	/*	 try
		 {
			 int a=1/0;
		 }
		 catch(Exception ex)
		 {
			 
		 }*/
	
		return ObjTransactionTestResponse;
	}

}
