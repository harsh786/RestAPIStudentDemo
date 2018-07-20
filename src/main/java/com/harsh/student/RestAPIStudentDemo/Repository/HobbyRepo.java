package com.harsh.student.RestAPIStudentDemo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.Hobbies;

@Repository
public interface HobbyRepo extends CrudRepository<Hobbies,Integer>{

}
