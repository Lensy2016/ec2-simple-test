package net.thewyvern.webapp.ec2.controller;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    public static final String HOSTNAME;

    static
    {
        try
        {
            HOSTNAME = InetAddress.getLocalHost().getHostName();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to retrieve hostname", e);
        }
    }

    @Value("${static.resources}")
    private String staticResources;

    public ModelAndView createMV(String page, String text)
    {
        ModelAndView modelAndView = new ModelAndView(page);
        modelAndView.addObject("title", text);
        return modelAndView;
    }

    @ModelAttribute("hostname")
    public String hostname()
    {
        return HOSTNAME;
    }

    @ModelAttribute("staticResourcesUrl")
    public String staticResourcesUrl() {
        return staticResources;
    }

}
