package com.harsh.student.RestAPIStudentDemo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.harsh.student.RestAPIStudentDemo.PhonenUMBERcUSTOMS;
import com.harsh.student.RestAPIStudentDemo.Repository.PhoneNumbersRepo;
import com.harsh.student.RestAPIStudentDemo.Repository.StudentRepo;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumber;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumberCustom;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumbers;
import com.harsh.student.RestAPIStudentDemo.model.Student;
import com.harsh.student.RestAPIStudentDemo.model.StudentDetails;
import com.harsh.student.RestAPIStudentDemo.model.StudentDetails2;




@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@PersistenceContext
	EntityManager objEntity;
	Student stud1;
	Student stud2;
	@Autowired
	private StudentRepo ObjStudentRepo;
	public StudentRepo getObjStudentRepo() {
		return ObjStudentRepo;
	}
	@Autowired
	private PhoneNumbersRepo ObjPhoneNumbersRepo;
	
	@Autowired
	private TestServiceImpl ObjTestServiceImpl;
	
	public void setObjStudentRepo(StudentRepo objStudentRepo) {
		ObjStudentRepo = objStudentRepo;
	}
	
	public PhoneNumbersRepo getObjPhoneNumbersRepo() {
		return ObjPhoneNumbersRepo;
	}

	public void setObjPhoneNumbersRepo(PhoneNumbersRepo objPhoneNumbersRepo) {
		ObjPhoneNumbersRepo = objPhoneNumbersRepo;
	}

	

	
	//if you not write transaction annotation then until exception is occured all data saved commit in db
	//if you write transaction then all checked exception are not rollback then unchecked exception are rollback
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public long InsertStudentRecords(Student ObjStudent) {
		
		/*
		new Thread(()->
				{
					Student stud1=	objEntity.find(Student.class, 2L);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
		

		new Thread(()->
				{
					
					Student stud2=	objEntity.find(Student.class, 2L);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}).start();
		
		try {
			Thread.sleep(000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(stud1==stud2)	
		{
			int a=1;
		}
		else
		{
			int a=1;
		}
			*/
		
		//If you save through phone repository
	/*	if(ObjStudent.getToCheckHowOneToManySqlWorks()==null)
	    {
		  ObjStudent.setToCheckHowOneToManySqlWorks(new HashSet<PhoneNumbers>());
	    }
		
		PhoneNumbers ObjPhoneNumber=new PhoneNumbers();
		ObjPhoneNumber.setPhoneNumber("9582492891");
		ObjPhoneNumber.setObjStudent(ObjStudent);
		return ObjPhoneNumbersRepo.save(ObjPhoneNumber).getObjStudent().getStudentId();*/
		
		
	//	ObjStudent.getToCheckHowOneToManySqlWorks().add(ObjPhoneNumber);
		
		// TODO Auto-generated method stub
		//this for one to many check
		if(ObjStudent.getToCheckHowOneToManySqlWorks()==null)
	    {
		 ObjStudent.setToCheckHowOneToManySqlWorks(new ArrayList<PhoneNumbers>());
	    }
		
		
		//this is coorect way  to do onetomany and manytoone
		PhoneNumbers ObjPhoneNumber=new PhoneNumbers();
		ObjPhoneNumber.setPhoneNumber(ObjStudent.getMobileNo());
		ObjStudent.addPhoneNumbers(ObjPhoneNumber);//important
		Student Obj=	ObjStudentRepo.save(ObjStudent);
		return Obj.getStudentId();
		
		
		//this is to check transactional
		
	/*	 if(ObjStudent.getLsPhoneNumber()==null)
		    {
			 ObjStudent.setLsPhoneNumber(new HashSet<PhoneNumber>());
		    }
		PhoneNumber ObjPhoneNumber=new PhoneNumber();
		ObjPhoneNumber.setPhoneNumber("9582492891");
		ObjStudent.getLsPhoneNumber().add(ObjPhoneNumber);
	    Student Obj=	ObjStudentRepo.save(ObjStudent);
	 return Obj.getStudentId()
	
	 
	/*	Student Obj=	ObjStudentRepo.save(ObjStudent);
		try
		{
			ObjTestServiceImpl.SavePhoneNumber();
			
		}
		catch(Exception ex)
		{
			
		}
		
		
		return Obj.getStudentId();*/
		/* if(ObjStudent.getLsPhoneNumber()==null)
		    {
			 ObjStudent.setLsPhoneNumber(new HashSet<PhoneNumber>());
		    }
		    
		    */
		
	    
	// 
	}

	/*@Transactional(propagation=Propagation.REQUIRES_NEW)*/
	@Transactional(propagation=Propagation.REQUIRED)
	private void SavePhoneNumber(Student objStudent) {
		throw new RuntimeException("Rollback this transaction1111!");
		// TODO Auto-generated method stub
//		PhoneNumber ObjPhoneNumber=new PhoneNumber();
//		ObjPhoneNumber.setPhoneNumber("9582492891");
//		objStudent.getLsPhoneNumber().add(ObjPhoneNumber);
	}

	@Override
	public Student UpdateStudentRecord(Student Obj, long Ids) {
		// TODO Auto-generated method stub
		Student studentOptional=ObjStudentRepo.findOne(Ids);
		//studentOptional.setRollNo(Obj.getRollNo());
		//studentOptional.setStudentName(Obj.getStudentName());
		PhoneNumbers ObjPhoneNumber=new PhoneNumbers();
		ObjPhoneNumber.setPhoneNumber(Obj.getMobileNo());
		studentOptional.addPhoneNumbers(ObjPhoneNumber);//important
		return ObjStudentRepo.save(studentOptional);
		
		
		//studentOptional.getLsPhoneNumber().add(ObjPhoneNumber);
		
	
	}

	@Override
	public List<Student> retrieveAllStudent() {
		// List<Student>Ob= (List<Student>) ObjStudentRepo.findAll();
		// return Ob;
		return ObjStudentRepo.findByDummyColumn("abc");
		
		//return ObjStudentRepo.findByToCheckHowOneToManySqlWorksObjStudent(ObjStudentRepo.findOne((long) 2));
	}

	@Override
	public Student retrieveStudent(long Ids1) {
		//return ObjStudentRepo.findOne(Ids1);
		
		//return ObjStudentRepo.findByStudentName("gaurav1");
	//	return ObjStudentRepo.findByToCheckHowOneToManySqlWorksPhoneNumber("95812341");
		
		//return ObjStudentRepo.findByToCheckHowOneToManySqlWorksId(1);
		//return ObjStudentRepo.findByToCheckHowOneToManySqlWorksIdAndToCheckHowOneToManySqlWorksPhoneNumber(2,"95812341");
		 return  ObjStudentRepo.findOne((long) 2);
	}
	
	

	

	@Override
	public void DeleteStudent(long Id) {
		ObjStudentRepo.delete(Id);
	}

	@Override
	public long InsertStudent2Record(Student objStudent) {
		/*StudentDetails Obj1=new StudentDetails();
		Obj1.setName("ojasvi");
		if(objStudent.getStudentdetails()==null)
		{
			objStudent.setStudentdetails(Obj1);	
		}
		
		
		StudentDetails2 Obj=new StudentDetails2();
		Obj.setName("karan");
		if(objStudent.getStudentDetails2()==null)
		{
			objStudent.setStudentDetails2(Obj);	
			Obj.setObjStudent2(objStudent);
		}
	return	ObjStudentRepo.save(objStudent).getStudentId();*/
		return 1;
		
	}
	
	
	@Override
	public List<PhonenUMBERcUSTOMS> retrieveAllStudentPhonenUmbers() {
		// List<Student>Ob= (List<Student>) ObjStudentRepo.findAll();
		// return Ob;
		//return ObjStudentRepo.findByDummyColumn("abc");
		
		//return ObjStudentRepo.findByToCheckHowOneToManySqlWorksObjStudent(ObjStudentRepo.findOne((long) 2));
	//	return ObjStudentRepo.findOne((long) 2).getToCheckHowOneToManySqlWorks();
		return ObjStudentRepo.findByToCheckHowOneToManySqlWorksIdAndToCheckHowOneToManySqlWorksObjStudent(2);
	}


	


	

}
