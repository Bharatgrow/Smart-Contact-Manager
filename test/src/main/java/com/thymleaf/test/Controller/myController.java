package com.thymleaf.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class myController {

    @RequestMapping(value = "/about", method=RequestMethod.GET)
    public String about(Model model){
        System.out.println("inside handler");

    model.addAttribute("name", "bharat");
        return "about";
    }

    @GetMapping("/condition")
    public String conditionHandler(Model model){

        model.addAttribute("isActive","user");
        model.addAttribute("gender","M");

        return "condition";
    }

    @GetMapping("/service")
    public String services(Model model){
        return "service";
    }

    @GetMapping("/aboutNew")
    public String newAbout(Model model){
        return "aboutNew";
    }
}
