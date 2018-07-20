package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.Gender;


@Repository
public interface GenderRepo extends CrudRepository<Gender,Integer> {

}
