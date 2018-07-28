package com.harsh.student.RestAPIStudentDemo.Repository;

import org.hibernate.jpa.criteria.CriteriaUpdateImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.model.FullTimeEmployee;

@Repository
public interface FullTimeEmplRepo extends CrudRepository<FullTimeEmployee,Long>
{

}
