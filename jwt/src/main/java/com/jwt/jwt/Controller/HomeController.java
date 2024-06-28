package com.jwt.jwt.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.jwt.Services.UserService;
import com.jwt.jwt.Models.User;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public List<User> admin(){

       
        return this.userService.getUsers();
    }

    @GetMapping("/currentUser")
    public String getLoggedInUser(Principal principal){

        return principal.getName();
    }

}
