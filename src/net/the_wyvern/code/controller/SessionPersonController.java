package net.the_wyvern.code.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.the_wyvern.code.bean.Person;
  
@Controller 
@SessionAttributes("sessionData")
public class SessionPersonController extends BaseController {  
  
	
    @ModelAttribute("sessionData")
    public Person sessionPersonData()
    {
        return new Person();
    }
    
    @RequestMapping(value="/session-person-form")  
    public ModelAndView personPage(@ModelAttribute("sessionData") Person sessionData) {    
        return new ModelAndView("person-page", "person", new Person());  
    }  
      
    @RequestMapping(value="/session-process-person")  
    public ModelAndView processPerson(@ModelAttribute("sessionData") Person sessionData, @ModelAttribute Person person) {  
        sessionData.setFirstName(person.getFirstName());
        sessionData.setAge(person.getAge());       
    	ModelAndView modelAndView = new ModelAndView("person-process-page");          
       
        System.out.println("Process: " + person);
        return modelAndView;  
    }     
    
    @RequestMapping(value="/session-finalize-person")  
    public ModelAndView finalizePerson(@ModelAttribute("sessionData") Person sessionData, @ModelAttribute Person person) {  
        sessionData.setLastName(person.getLastName());
        sessionData.setShoeSize(person.getShoeSize());

    	ModelAndView modelAndView = new ModelAndView("person-result-page");  
                   
        System.out.println("Finalize: " + person);
        return modelAndView;  
    }   
} 