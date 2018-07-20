package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.Test1;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.department;
@Repository
public interface Test1Repo extends CrudRepository<Test1,Integer>{

}
