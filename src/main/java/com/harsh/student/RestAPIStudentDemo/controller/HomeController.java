package com.harsh.student.RestAPIStudentDemo.controller;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
 
	
	@RequestMapping(value="/")
	public ModelAndView Home()
	{
	 ModelAndView ob=new ModelAndView();
	 User o=new User();
	 ob.addObject("user", o);
	// o.setErrorMsg("User name and password not matched");
	 ob.setViewName("home");	
	 return ob;
	}
	
	
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String login( @Valid @ModelAttribute("user") User ob,BindingResult error,RedirectAttributes redirectAttributes,Model model)
	{
	  
	 if(error.hasErrors())
	 {
		 ob.setIsError(false);
		 ob.setErrorMsg("yo");
		 return "home";
	 }
	 else
	 {
		 if(ob.getUserName().equals("harsh") && ob.getPassword().equals("1234"))
		 {
			    
			    redirectAttributes.addFlashAttribute("user", ob);
		        return  "redirect:/dashboard";
		 }
		 else
		 {
			 ob.setIsError(true);
			 ob.setErrorMsg("User name and password not matched");
			// model.addAttribute("user",ob);
			 
		  return "home";
		 }
	 }
	
		
	
	}
	
}
