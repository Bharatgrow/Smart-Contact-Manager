package com.formvalidation.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formvalidation.form.Entity.loginData;

import jakarta.validation.Valid;

@Controller
public class MyController {

    @GetMapping("/fm")
    public String login(Model model){

        model.addAttribute("loginData", new loginData());
        return "lg";

    }

    @PostMapping("/process")
    public String success(@Valid  @ModelAttribute("loginData") loginData data, BindingResult result){
        System.out.println(data);

        if(result.hasErrors()){
            System.out.println(result);
            return "lg";
        }

        return "success";
    }
    
}
