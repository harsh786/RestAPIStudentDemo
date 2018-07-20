package com.harsh.student.RestAPIStudentDemo.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harsh.student.RestAPIStudentDemo.PhonenUMBERcUSTOMS;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumberCustom;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumbers;
import com.harsh.student.RestAPIStudentDemo.model.Student;

@Repository("StudentRepo")
public interface StudentRepo extends CrudRepository<Student,Long>{
	
   Student findByStudentName(String name);
   
   List<Student> findByDummyColumn(String Name);

   Student findByToCheckHowOneToManySqlWorksPhoneNumber(String Name);
   Student findByToCheckHowOneToManySqlWorksId(long Id);
   
   Student findByToCheckHowOneToManySqlWorksIdAndToCheckHowOneToManySqlWorksPhoneNumber(long Id,String Name);
   Student findBydummyColumn1(String name);
   
  // List<Student> findByToCheckHowOneToManySqlWorksObjStudent(Student s);
   List<Student> findByToCheckHowOneToManySqlWorksObjStudent(Student s);
   
   @Query( nativeQuery=true,value="Select id as id ,phoneNumber as phoneNumber from  PHONE_NUMBERS_TBL A    where A.STUDENT_ID=?1")
   List<PhonenUMBERcUSTOMS>findByToCheckHowOneToManySqlWorksIdAndToCheckHowOneToManySqlWorksObjStudent(long Id);
}
