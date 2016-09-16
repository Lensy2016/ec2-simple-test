package net.thewyvern.webapp.ec2.attic;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
  
// @Controller  
public class SecondController {  
  
    @RequestMapping(value="/second-page")  
    public ModelAndView goToHelloPage() {  
        ModelAndView view = new ModelAndView();  
        view.setViewName("hello"); //name of the jsp-file in the "page" folder  
          
        String str = "MVC Spring is still here!";  
        view.addObject("message", str); //adding of str object as "message" parameter  
          
        return view;  
    }  
      
} 