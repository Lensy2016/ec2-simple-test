package net.the_wyvern.code.controller;

import java.net.InetAddress;

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

    public ModelAndView createMV(String page, String text)
    {
        ModelAndView modelAndView = new ModelAndView(page);
        modelAndView.addObject("message", text);
        return modelAndView;
    }

    @ModelAttribute("hostname")
    public String hostname()
    {
        return HOSTNAME;
    }
}
