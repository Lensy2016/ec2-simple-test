package net.the_wyvern.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.the_wyvern.code.model.SessionData;
  
@Controller
@SessionAttributes("sessionData")
public class FirstController extends BaseController {  
  
    @ModelAttribute("sessionData")
    public SessionData sessionData()
    {
        return new SessionData();
    }
    
    @RequestMapping(value="/hello-page")  
    public ModelAndView goToHelloPage() {  
    	String str = "MVC Spring is here!";
    	return createMV("hello", str);
        
    	// view.addObject("message", str); //adding of str object as "message" parameter  
       
          
    }  
      
    @RequestMapping(value="/second-page")  
    public ModelAndView secondPage() {
        String str = "MVC Spring is still here!"; 
        return createMV("hello", str);
    }
} 