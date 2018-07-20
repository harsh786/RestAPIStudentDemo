package com.harsh.student.RestAPIStudentDemo.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harsh.student.RestAPIStudentDemo.PhonenUMBERcUSTOMS;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumberCustom;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumbers;
import com.harsh.student.RestAPIStudentDemo.model.Student;
import com.harsh.student.RestAPIStudentDemo.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController  {

	@Autowired
	private StudentService ObjStudentService;

	public StudentService getObjStudentService() {
		return ObjStudentService;
	}

	public void setObjStudentService(StudentService objStudentService) {
		ObjStudentService = objStudentService;
	}
	
	@ResponseBody
	@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long  InsertStudentRecord(@Valid @RequestBody Student ObjStudent1)
	{
		return ObjStudentService.InsertStudentRecords(ObjStudent1);
		
	}
	
	@ResponseBody
	@PutMapping(value="/update/{id}")
	public Student  UpdateStudentRecord(@Valid @RequestBody Student ObjStudent,@PathVariable long id)
	{
		return ObjStudentService.UpdateStudentRecord(ObjStudent, id);
		
	}
	@ResponseBody
	@RequestMapping(value="/all")
	public List<Student>  GetsAllStudentRecord()
	{
		return ObjStudentService.retrieveAllStudent();
		
	}
	@ResponseBody
	@RequestMapping(value="/all/{id}")
	public Student  GetsStudentRecord(@PathVariable long id)
	{
		Student Ob= ObjStudentService.retrieveStudent(id);
	/*	if(Ob.getLsPhoneNumber().size()==0)
		{
			int a=1;
			a=a+1;
		}*/
		return Ob;
		
		
	}
	@ResponseBody
	@DeleteMapping(value="/delete/{id}")
	public void  DeleteStudentRecord(@PathVariable long id)
	{
		 ObjStudentService.DeleteStudent(id);;
		
	}
	
	
	@ResponseBody
	@PostMapping(value="/insertStudent2")
	public long  InsertStudent2Record(@Valid @RequestBody Student ObjStudent)
	{
		return ObjStudentService.InsertStudent2Record(ObjStudent);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/StudentPhoneRecord")
	public List<PhonenUMBERcUSTOMS>  GetsStudentPhoneRecord()
	{
	//	return ObjStudentService.retrieveAllStudent();
		return ObjStudentService.retrieveAllStudentPhonenUmbers();
	}
	
}
