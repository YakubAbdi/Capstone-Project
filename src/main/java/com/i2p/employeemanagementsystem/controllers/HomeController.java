package com.i2p.employeemanagementsystem.controllers;

import com.i2p.employeemanagementsystem.models.Employee;
import com.i2p.employeemanagementsystem.models.User;
import com.i2p.employeemanagementsystem.repository.UserRepo;
import com.i2p.employeemanagementsystem.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private EmployeeServiceImp employeeService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/about")
    public String viewAboutPage(Model model){
        model.addAttribute("about", "Welcome! Here is the change in the traditional educational system where there was no any automated or web based or technology based systems, we are here to provide the solution for that problem. Here any user who will opt this application will be able to manage the record of their employees. ");
        return "about";
    }
    @GetMapping("/home")
    public String viewHomePage(Model model){
        model.addAttribute("about", "Welcome! Here is the change in the traditional educational system where there was no any automated or web based or technology based systems, we are here to provide the solution for that problem. Here any user who will opt this application will be able to manage the record of their employees. ");
        return "index";
    }
    @GetMapping("/contactus")
    public String contactus(Model model){
        return "contactus";
    }

    @GetMapping("/signin")
    public String customLogin(Model model)
    {
        model.addAttribute("title","Login Page");
        return "login";
    }
    @PostConstruct
    public void AdminUser(){
        List<User> user= userRepo.findAll();
        if(user.isEmpty()){
           User user1= new User();
           user1.setName("admin");
           user1.setAbout("administrator");
           user1.setEmail("Yakabdi1@gmail.com");
           user1.setPassword(bCryptPasswordEncoder.encode("admin"));
           user1.setEnabled(true);
           user1.setRole("ROLE_ADMIN");
           userRepo.save(user1);
        }
    }
}
