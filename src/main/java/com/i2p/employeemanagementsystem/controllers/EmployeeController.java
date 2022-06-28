package com.i2p.employeemanagementsystem.controllers;

import com.i2p.employeemanagementsystem.models.Employee;
import com.i2p.employeemanagementsystem.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeService;


    @GetMapping("/employees")
    public String getPro(Model model){
        model.addAttribute("products", employeeService.getAll());
        return "products";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contactus";
    }

    /**
     * Only admin has the ability to add employees
     */
    @GetMapping("/add")
    public String addPro(Model model){
        model.addAttribute("productDTO", new Employee());
//        model.addAttribute("categories", categoryService.getAll());
        return "productsAdd";
    }
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("productDTO") Employee productDto) throws IOException {
        employeeService.addEmployee(productDto);
        return "redirect:/employees";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deletePro(@PathVariable int id){
        employeeService.deleteById( id);
        return "redirect:/employees";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProd(@PathVariable int id, Model model){
        Employee product= employeeService.getById(id);
        model.addAttribute("productDTO", product);
        return "productsAdd";
    }



}
