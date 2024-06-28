package com.smartcontact.smartcontactmanager.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontact.smartcontactmanager.Service.EmailService;
import com.smartcontact.smartcontactmanager.dao.UserRepository;
import com.smartcontact.smartcontactmanager.entity.User;

import jakarta.servlet.http.HttpSession;


@Controller
public class forgotController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
        private EmailService emailService;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/forgot")
    public String openEmailForm(){

        return "forgotEmail";
    }


    @PostMapping("/sendOTP")
    public String sendOTP(@RequestParam("email") String email,HttpSession session){

        

        System.out.println(email);

        Random random=new Random();
        int otp=random.nextInt(9999);

        String subject="OTP from SCM";
        String message="<h1> OTP:"+otp+"</h1>";
        String to=email;

       boolean flag= this.emailService.sendEmail(subject, message, to);

       if (flag) {

        session.setAttribute("myotp", otp);
        session.setAttribute("email", email);
        return "verifyOTP";
       }
       

        return "forgotEmail";
    }

    @PostMapping("/verifyOTP")
    public String verifyotp(@RequestParam("otp") int  otp,HttpSession session){

        int myotp=(Integer)session.getAttribute("myotp");
        String email=(String) session.getAttribute("email");

        if (myotp==otp) {

            User user=userRepository.getUserByName(email);

            if (user==null) {

                return "forgotEmail";

                
            }
            return "changePassword";
            
        }

        return "verifyOTP";       
    }

    @PostMapping("/newPassword")
    public String newPassword(@RequestParam("password") String password,HttpSession session){

        String email=(String) session.getAttribute("email");
       User user= this.userRepository.getUserByName(email);
       user.setPassword(this.bCryptPasswordEncoder.encode(password));
       this.userRepository.save(user);


        return "login";
    }
}
