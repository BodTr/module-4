package com.spring.demo_jpa_repository.controller;

import com.spring.demo_jpa_repository.model.Customer;
import com.spring.demo_jpa_repository.model.Province;
import com.spring.demo_jpa_repository.service.ICustomerService;
import com.spring.demo_jpa_repository.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> listProvinces() {
        return provinceService.findAll();
    }

    @GetMapping("")
    public ModelAndView listCustomers() {
        ModelAndView mav = new  ModelAndView("/customer/list");
        Iterable<Customer> customers = customerService.findAll();
        mav.addObject("customers", customers);
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView mav = new ModelAndView("/customer/create");
        mav.addObject("customer", new Customer());
        return mav;

    }

    @PostMapping("/save")
    public ModelAndView saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView mav = new ModelAndView("/customer/create");
            return mav;
        }
        customerService.save(customer);
        ModelAndView mav = new ModelAndView("/customer/create");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @GetMapping("/{firstName}")
    public String showCustomer(@PathVariable String firstName) {
        List<Customer> customers = customerService.findTop3ByFirstName(firstName);
        return "";
    }
}
