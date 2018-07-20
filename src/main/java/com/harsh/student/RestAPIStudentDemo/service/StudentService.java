package com.harsh.student.RestAPIStudentDemo.service;

import java.util.List;
import java.util.Set;

import com.harsh.student.RestAPIStudentDemo.PhonenUMBERcUSTOMS;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumberCustom;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumbers;
import com.harsh.student.RestAPIStudentDemo.model.Student;

public interface StudentService {
	
 public long InsertStudentRecords(Student ObjStudent);
 public Student UpdateStudentRecord(Student Obj,long Id);
 public Student retrieveStudent(long Id);
 public void DeleteStudent(long Id);
 public List<Student> retrieveAllStudent();
public long InsertStudent2Record(Student objStudent);
public List<PhonenUMBERcUSTOMS> retrieveAllStudentPhonenUmbers();
 
}
