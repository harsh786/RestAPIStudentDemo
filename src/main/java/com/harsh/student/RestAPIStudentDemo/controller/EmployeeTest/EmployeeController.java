package com.harsh.student.RestAPIStudentDemo.controller.EmployeeTest;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harsh.student.RestAPIStudentDemo.TestPropertiesConfig;
import com.harsh.student.RestAPIStudentDemo.TestPropertiesConfig.students;
import com.harsh.student.RestAPIStudentDemo.Repository.DeptRepo;
import com.harsh.student.RestAPIStudentDemo.Repository.EmployeeRepo;
import com.harsh.student.RestAPIStudentDemo.Repository.FullTimeEmplRepo;
import com.harsh.student.RestAPIStudentDemo.Repository.GenderRepo;
import com.harsh.student.RestAPIStudentDemo.Repository.HobbyRepo;
import com.harsh.student.RestAPIStudentDemo.Repository.StudentRepo;
import com.harsh.student.RestAPIStudentDemo.model.FullTimeEmployee;
import com.harsh.student.RestAPIStudentDemo.model.FulleTimeEmpPhoneNo;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.Employee;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.Hobbies;
import com.harsh.student.RestAPIStudentDemo.model.EmployeeTest.department;
import com.harsh.student.RestAPIStudentDemo.service.Test1Service;
import com.harsh.student.RestAPIStudentDemo.service.Test1ServiceImpl;
import com.sun.jersey.api.client.ClientResponse.Status;


 class HobbiesEntityEditor extends PropertyEditorSupport {
	 @Override
    public void setAsText(final String text) {
        final Hobbies HobbiesEntity = new Hobbies();
        HobbiesEntity.setId(Integer.parseInt(text));
        this.setValue(HobbiesEntity);
    }

    @Override
    public String getAsText() {
        return String.valueOf(((Hobbies) this.getValue()).getId());
    }
}
 class departmentEntityEditor extends PropertyEditorSupport {
	 @Override
    public void setAsText(final String text) {
        final department departmentEntity = new department();
        departmentEntity.setId(Integer.parseInt(text));
        this.setValue(departmentEntity);
    }

    @Override
    public String getAsText() {
     String s=   String.valueOf(((department) this.getValue()).getId());
     return s;
    }
}
 
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepo objEmployeeRepo;
	@Autowired
	private DeptRepo objDeptRepo;
	@Autowired
	private GenderRepo objGenderRepo;
	@Autowired
	private HobbyRepo objHobbyRepo;
	
	@Autowired
	private TestPropertiesConfig objTestPropertiesConfig;
	
	@Autowired
	private Test1Service objTest1ServiceImpl;
	
	@Autowired
	private FullTimeEmplRepo objFullTimeEmplRepo;

	@Autowired
	private StudentRepo objStudentRepo;
	
	public Test1Service getObjTest1ServiceImpl() {
		return objTest1ServiceImpl;
	}

	public void setObjTest1ServiceImpl(Test1Service objTest1ServiceImpl) {
		this.objTest1ServiceImpl = objTest1ServiceImpl;
	}

	public TestPropertiesConfig getObjTestPropertiesConfig() {
		return objTestPropertiesConfig;
	}

	public void setObjTestPropertiesConfig(TestPropertiesConfig objTestPropertiesConfig) {
		this.objTestPropertiesConfig = objTestPropertiesConfig;
	}

	public DeptRepo getObjDeptRepo() {
		return objDeptRepo;
	}

	public void setObjDeptRepo(DeptRepo objDeptRepo) {
		this.objDeptRepo = objDeptRepo;
	}
	
	public GenderRepo getObjGenderRepo() {
		return objGenderRepo;
	}

	public void setObjGenderRepo(GenderRepo objGenderRepo) {
		this.objGenderRepo = objGenderRepo;
	}

	public HobbyRepo getObjHobbyRepo() {
		return objHobbyRepo;
	}

	public void setObjHobbyRepo(HobbyRepo objHobbyRepo) {
		this.objHobbyRepo = objHobbyRepo;
	}
	
	public EmployeeRepo getObjEmployeeRepo() {
		return objEmployeeRepo;
	}

	public void setObjEmployeeRepo(EmployeeRepo objEmployeeRepo) {
		this.objEmployeeRepo = objEmployeeRepo;
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
	  //  binder.registerCustomEditor(Hobbies.class, new HobbiesEntityEditor());
	  binder.registerCustomEditor(department.class, new departmentEntityEditor());
	}
	
	@RequestMapping(value="/emp")
	public String EmployeeOps(Model model)
	{
		
	//	objStudentRepo.findOne(id)
		
		FullTimeEmployee objFullTimeEmployee=new FullTimeEmployee();
		objFullTimeEmployee.setName("harsh1");
		objFullTimeEmployee.setSalary(10000);
		objFullTimeEmployee.setStatus(FullTimeEmployee.State.ACTIVE);
		FulleTimeEmpPhoneNo objFulleTimeEmpPhoneNo=new FulleTimeEmpPhoneNo();
		objFulleTimeEmpPhoneNo.setNumber("9582492891");
		List<FulleTimeEmpPhoneNo>ls=objFullTimeEmployee.getLs();
		ls.add(objFulleTimeEmpPhoneNo);
		objFullTimeEmployee.setLs(ls);
		objFulleTimeEmpPhoneNo.setObjFullTimeEmployee(objFullTimeEmployee);
		objFullTimeEmplRepo.save(objFullTimeEmployee);
		
	//	TestPropertiesConfig o=	objTestPropertiesConfig;
		students o=objTestPropertiesConfig.getObjstudents();
		System.out.println(o.getId());
		System.out.println(o.getName());
		
//		objTest1ServiceImpl.InsertDetailsTest1AndTest2();
		//objTest1ServiceImpl.InsertDetailsTest1AndTest2AnotherTran();
	    Employee ob=	objEmployeeRepo.findOne(1);
	 
		model.addAttribute("emp", ob);
		//model.addAttribute("emp", new Employee());
		return "EmpView";
	}
	@RequestMapping(value="/empupdate")
	public String empupdate(Model model)
	{
		
		FullTimeEmployee objFullTimeEmployee=objFullTimeEmplRepo.findOne(1L);
		//FullTimeEmployee objFullTimeEmployee=new FullTimeEmployee();
		objFullTimeEmployee.setName("harshupdate1");
		objFullTimeEmployee.setSalary(2220000);
		
		objFullTimeEmplRepo.save(objFullTimeEmployee);
		
	//	TestPropertiesConfig o=	objTestPropertiesConfig;
		students o=objTestPropertiesConfig.getObjstudents();
		System.out.println(o.getId());
		System.out.println(o.getName());
		
//		objTest1ServiceImpl.InsertDetailsTest1AndTest2();
		//objTest1ServiceImpl.InsertDetailsTest1AndTest2AnotherTran();
	    Employee ob=	objEmployeeRepo.findOne(1);
	 
		model.addAttribute("emp", ob);
		//model.addAttribute("emp", new Employee());
		return "EmpView";
	}
	

	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String EmployeeOps(@ModelAttribute("emp")@Valid Employee emp,BindingResult error,Model model)
	{
		//objEmployeeRepo.save(emp);
		/*if(emp.getObjHobbies().size()<=0)
		{
			error.rejectValue("objHobbies", "not selected","not selected i");
			return "EmpView";
		}
		else
		{
			
		}
		StringBuilder s=new StringBuilder();
		 emp.getObjHobbies().forEach(x->s.append(x.getId()+" "));*/
//		model.addAttribute("selecteddept",s.toString());
		return "EmpView";
	}
	
	@ModelAttribute("hobbies")
	public Map<Integer,String> getHobbies()
	{
		Map<Integer,String> mp=new HashMap<Integer,String>();
		 objHobbyRepo.findAll().forEach(item->mp.put(item.getId(),item.getName()));
		
		return mp;
		
	}
	@ModelAttribute("gender")
	public Map<Integer,String> getGender()
	{
		Map<Integer,String> mp=new HashMap<Integer,String>();
		objGenderRepo.findAll().forEach(item->mp.put(item.getId(),item.getName()));
		return mp;
		
	}
	@ModelAttribute("dept")
	public Map<Integer,String> getDept()
	{
		Map<Integer,String> mp=new HashMap<Integer,String>();
		objDeptRepo.findAll().forEach(item->mp.put(item.getId(),item.getName()));
		return mp;
		
	}

	public FullTimeEmplRepo getObjFullTimeEmplRepo() {
		return objFullTimeEmplRepo;
	}

	public void setObjFullTimeEmplRepo(FullTimeEmplRepo objFullTimeEmplRepo) {
		this.objFullTimeEmplRepo = objFullTimeEmplRepo;
	}

	
}
