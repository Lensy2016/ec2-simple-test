package net.thewyvern.webapp.ec2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController
{

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView home(HttpSession session)
    {
    	session.invalidate();
        ModelAndView modelAndView = createMV("pages.home", "welcome");
        return modelAndView;
    }

}
