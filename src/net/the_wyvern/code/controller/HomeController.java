package net.the_wyvern.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.the_wyvern.code.model.SessionData;

@Controller
@SessionAttributes("sessionData")
public class HomeController extends BaseController
{

    @ModelAttribute("sessionData")
    public SessionData sessionData()
    {
        return new SessionData();
    }

    @RequestMapping(value = {"/home"})
    public ModelAndView home()
    {
        return createMV("home", "welcome");
    }

    @RequestMapping(value = "/process")
    public String process(@ModelAttribute("sessionData") SessionData sessionData, @RequestParam("value") String value)
    {
        sessionData.setProcessedBy(hostname());
        sessionData.setValue(value);

        return "redirect:/home";
    }

}
