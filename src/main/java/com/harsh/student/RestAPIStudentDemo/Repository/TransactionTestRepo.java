package com.harsh.student.RestAPIStudentDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;

import com.harsh.student.RestAPIStudentDemo.PhonenUMBERcUSTOMS;
import com.harsh.student.RestAPIStudentDemo.model.TransactionTest;


@Repository
public interface TransactionTestRepo  extends CrudRepository<TransactionTest,Integer>{
	@Modifying
	@Query( nativeQuery=true,value="update TransactionTest set age=25 where id=?1")
	   public int UpdateAgeOfTranactionTestNativeSql(Integer id) ;
	
	@Modifying(clearAutomatically=true)
	@Query( value="update TransactionTest t set t.age=9 where t.id=?1")
	   public int UpdateAgeOfTranactionTestNativeJpql(Integer id) ;
	
	
	@Modifying
	@Query( nativeQuery=true,value="update TransactionTest set name='gaurav' where id=?1")
	   public int UpdateNameOfTranactionTestNativeSql(Integer id) ;
	@Modifying(clearAutomatically=true)
	@Query( value="update TransactionTest t set t.name='karan9' where t.id=?1")
	   public int UpdateNameOfTranactionTestNativeJpql(Integer id) ;
	
	@org.springframework.transaction.annotation.Transactional(isolation=Isolation.READ_COMMITTED)
	@Query( value="Select t from TransactionTest t  where t.id=?1")
	public TransactionTest GetDataFromId(Integer id);
	
}
