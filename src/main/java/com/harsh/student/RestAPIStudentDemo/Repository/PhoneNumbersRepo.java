package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.PhoneNumbers;
import com.harsh.student.RestAPIStudentDemo.model.Student;

@Repository("PhoneNumbers")
public interface PhoneNumbersRepo extends CrudRepository<PhoneNumbers,Long>{

}
