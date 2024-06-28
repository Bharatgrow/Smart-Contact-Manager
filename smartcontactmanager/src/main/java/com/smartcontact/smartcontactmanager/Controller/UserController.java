package com.smartcontact.smartcontactmanager.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smartcontact.smartcontactmanager.dao.ContactRepository;
import com.smartcontact.smartcontactmanager.dao.UserRepository;
import com.smartcontact.smartcontactmanager.entity.Contact;
import com.smartcontact.smartcontactmanager.entity.User;
import com.smartcontact.smartcontactmanager.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @ModelAttribute
    public void addCommonData(Model model,Principal principal,HttpSession session){
        session.removeAttribute("message");
        String userName=principal.getName();
        System.out.println(userName);

        User user=userRepository.getUserByName(userName);

        model.addAttribute("user", user);

        System.out.println(user);


    }
    // index

    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal,HttpSession session){
        session.removeAttribute("message");
        return "normal/user_dashboard";
    }
    // addcontact

    @GetMapping("/addContact")
    public String AddContact(Model model,HttpSession session){
        session.removeAttribute("message");
        model.addAttribute("title", "Add Contact");

        model.addAttribute("contact", new Contact());

        return "normal/addContact";
    }
    // processcontact

    @PostMapping("/process-contact")
    public String processContact(@RequestParam("imageUrl") MultipartFile image,
    @ModelAttribute Contact contact,Principal principal,HttpSession session){
         session.removeAttribute("message");
        try{
        String name=principal.getName();

        User user=userRepository.getUserByName(name);

        if(image.isEmpty()){
            contact.setImage("default.png");

        }
        else{
            contact.setImage(image.getOriginalFilename());

           File file= new ClassPathResource("static/image").getFile();

         Path path=  Paths.get(file.getAbsolutePath()+File.separator+image.getOriginalFilename());

           Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

           System.out.println("image is uploaded");
        }

        contact.setUser(user);

        user.getContact().add(contact);

        userRepository.save(user);

        session.setAttribute("message", new Message("your contact is added","success") );

        

        }
        catch(Exception e){
            e.printStackTrace();

            session.setAttribute("message", new Message("something went wrong","danger") );


        }
        return "normal/addContact";
    }
    // showConatct

    @GetMapping("/showContact/{page}")
    public String ViewContact(@PathVariable("page") Integer page,Model model,Principal principal){

        String userName=principal.getName();
       User user= userRepository.getUserByName(userName);
 
       Pageable pageable= PageRequest.of(page, 5);
       Page<Contact> contacts= contactRepository.findByUser(user.getId(),pageable);

       model.addAttribute("contacts", contacts);
       model.addAttribute("currentpage", page);
       model.addAttribute("totalpages", contacts.getTotalPages());
      
        model.addAttribute("title", "view contacts");
        return "normal/showContact";
    }
    // contactDetail

    @RequestMapping("/{cId}/contact")
    public String showContactDetail(@PathVariable("cId") Integer cId,Model model,Principal principal){
        System.out.println(cId);

        model.addAttribute("title", "contacts Detail");

        Optional<Contact>contactOptional=contactRepository.findById(cId);

        String userName=principal.getName();

       User user= userRepository.getUserByName(userName);

        Contact contact=contactOptional.get();

        if(user.getId()==contact.getUser().getId()){
        model.addAttribute("contact", contact);
        model.addAttribute("title", contact.getName());
        }

        return "normal/contact_Detail";
    }
    // deletecontact

    @GetMapping("/delete/{cId}")
    public String deleteContact(@PathVariable("cId") Integer cId,Model model,Principal principal,HttpSession session){

       Optional<Contact> contacOptional= contactRepository.findById(cId);

       Contact contact=contacOptional.get();

       String userName=principal.getName();

       User user=userRepository.getUserByName(userName);

       if(user.getId()==contact.getUser().getId()){

       contactRepository.delete(contact);
       session.setAttribute("message", new Message("contact deleted successfully","success"));
    }

        return "redirect:/user/showContact/0";
    }
    // updatecontact

    @PostMapping("/update/{cId}")
    public String update(@PathVariable("cId") Integer cId,Model model){

        model.addAttribute("title", "update Contact");

        Contact contact=contactRepository.findById(cId).get();

        model.addAttribute("contact", contact);

        return "normal/updateContact";
    }

    @PostMapping("/edit-contact")
    public String updateContact(@ModelAttribute Contact contact,@RequestParam("imageUrl")MultipartFile image,Model model,HttpSession session,Principal principal){

       Contact oldDetail= contactRepository.findById(contact.getcId()).get();
        try{

            if(!image.isEmpty()){

                File file= new ClassPathResource("static/image").getFile();

                Path path=  Paths.get(file.getAbsolutePath()+File.separator+image.getOriginalFilename());
       
                  Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                  contact.setImage(image.getOriginalFilename());

            }
            else{
                contact.setImage(oldDetail.getImage());
            }

            User user=userRepository.getUserByName(principal.getName());
            contact.setUser(user);
            contactRepository.save(contact);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/user/showContact/0";
    }

    // profileview

    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute("title", "Profile Page");
        return "normal/profile";
    }
//setting view
    @GetMapping("/setting")
    public String openSetting(){
        return "normal/setting";
    }

    //changePassword
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("oldPassword")String oldPassword, @RequestParam("newPassword")String newPassword
,Principal principal){


    String username=principal.getName();

    User user=this.userRepository.getUserByName(username);

    if(bCryptPasswordEncoder.matches(oldPassword, user.getPassword())){

        user.setPassword(this.bCryptPasswordEncoder.encode(newPassword));
        this.userRepository.save(user);

    }else{
        return "redirect:/user/setting";
    }

        return "redirect:/user/index";
    }
}
