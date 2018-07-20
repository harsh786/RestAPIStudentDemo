package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.Test2;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.department;
@Repository
public interface Test2Repo extends CrudRepository<Test2,Integer> {

}
