package net.the_wyvern.code.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import net.the_wyvern.code.bean.Person;  
  
@Controller  
public class PersonController extends BaseController {  
  
    @RequestMapping(value="/person-form")  
    public ModelAndView personPage(HttpSession session, Model model) {    	 
    	// Bit of a hack because I'm lazy and sharing pages/code
    	session.invalidate();
    	if(model.containsAttribute("sessionData")) model.asMap().remove("sessionData");
    	  
        return new ModelAndView("person-page", "person", new Person());  
    }  
      
    @RequestMapping(value="/process-person")  
    public ModelAndView processPerson(@ModelAttribute Person person) {  
        ModelAndView modelAndView = new ModelAndView("person-process-page", "person", person);          
       
        System.out.println("Process: " + person);
        return modelAndView;  
    }     
    
    @RequestMapping(value="/finalize-person")  
    public ModelAndView finalizePerson(@ModelAttribute Person person) {  
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("person-result-page");  
          
        modelAndView.addObject("pers", person);  
          
        System.out.println("Finalize: " + person);
        return modelAndView;  
    }   
} 