package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.Hobbies;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.department;

@Repository
public interface DeptRepo extends CrudRepository<department,Integer>{

}
