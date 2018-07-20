package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.Student;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.Employee;

@Repository("employeeRepo")
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
 
	
	
}
