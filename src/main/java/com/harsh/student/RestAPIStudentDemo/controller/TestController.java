package com.harsh.student.RestAPIStudentDemo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harsh.student.RestAPIStudentDemo.service.StudentService;
import com.harsh.student.RestAPIStudentDemo.model.PhoneNumbers;
import com.harsh.student.RestAPIStudentDemo.model.Student;
@Controller
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	private StudentService ObjStudentService;
	private static final String KEY = "STUDENT";
	 
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, Student> hashOperations;
	private ListOperations<String, Object> listOperations;
	private org.springframework.data.redis.core.SetOperations<String, Object> SetOperations;
	private HashOperations<String, Long, Student> valuesOperations;
	@Autowired
	public TestController(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
 
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
		listOperations=redisTemplate.opsForList();
		SetOperations=redisTemplate.opsForSet();
		//valuesOperations=redisTemplate.opsForValue();
	}
	
	@ResponseBody
	@RequestMapping(value="/all",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Student> GetStudents(@RequestBody Student ObjStudent )
	{
		
		
		
		Student Obj=new Student();
		Obj.setMobileNo("9582492891");
		Obj.setRollNo("9582492891");
		Obj.setStudentId(1);
		Obj.setStudentName("HARSH");
	    PhoneNumbers p1=new PhoneNumbers();
	    p1.setId(1);
	    p1.setPhoneNumber("99999999");
	    List<PhoneNumbers>ls=new ArrayList<PhoneNumbers>();
	    ls.add(p1);
	    Obj.setToCheckHowOneToManySqlWorks(ls);
	    
	    
	    
	   /*
	    * redis
	    * 
	    */
	   // hashOperations.put("STUDENT", Obj.getStudentId(), Obj);
	    
	    ResponseEntity<Student>res=new ResponseEntity<Student>(Obj,HttpStatus.OK);
	  
	    return res;
	  
	}
	
	
	@RequestMapping(value="/all1",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Student> GetStudents1(@RequestBody MultiValueMap<String, String>student )
	{
		/*RequestEntity<Student> u=new RequestEntity<Student>(HttpMethod.GET,URI.create(""));
		HttpHeaders hh= u.getHeaders();*/
		
		String Id=student.getFirst("id");
		String Name =student.getFirst("name");
		System.out.println("id is:"+Id);
		System.out.println("name is:"+Name);
		Student Obj=new Student();
		Obj.setMobileNo("9582492891");
		Obj.setRollNo("9582492891");
		Obj.setStudentId(1);
		Obj.setStudentName("HARSH");
	    PhoneNumbers p1=new PhoneNumbers();
	    p1.setId(1);
	    p1.setPhoneNumber("99999999");
	    List<PhoneNumbers>ls=new ArrayList<PhoneNumbers>();
	    ls.add(p1);
	    Obj.setToCheckHowOneToManySqlWorks(ls);
	    
	    //ResponseEntity<Student>res=new ResponseEntity<Student>(Obj,HttpStatus.OK);
	   // CacheControl mustRevalidate = CacheControl();'
	    //mustRevalidate.mustRevalidate();
	   
	    
	    
	    return   ResponseEntity.status(HttpStatus.ACCEPTED).header("keysss", "values")
	    		.cacheControl(CacheControl.maxAge(100000, TimeUnit.SECONDS).mustRevalidate())
	    		.location(URI.create("gfgg"))
	    		.eTag("harsh1").body(Obj);
	    
	 // return  ResponseEntity.ok().eTag("harsh1").body(Obj);
	
	   // return res;
	  
	}


	
}
