package net.thewyvern.webapp.ec2.controller;

import net.thewyvern.webapp.ec2.model.SessionData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("sessionData")
public class HomeController extends BaseController
{

    @ModelAttribute("sessionData")
    public SessionData sessionData()
    {
        return new SessionData();
    }

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView home()
    {
        ModelAndView modelAndView = createMV("pages.home", "welcome");
        return modelAndView;
    }

    @RequestMapping(value = "/process")
    public String process(@ModelAttribute("sessionData") SessionData sessionData, @RequestParam("value") String value)
    {
        sessionData.setProcessedBy(hostname());
        sessionData.setValue(value);

        return "redirect:/home";
    }

}
