package com.spring.demo_spring_boot_1.controller;

import com.spring.demo_spring_boot_1.model.Customer;
import com.spring.demo_spring_boot_1.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView listCustomer() {
        ModelAndView mav = new ModelAndView("customer/list");
        mav.addObject("customers", customerService.findAll());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView mav = new ModelAndView("customer/create");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Valid @ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView mav = new ModelAndView("/customer/create");
        mav.addObject("customer", new Customer());
        mav.addObject("message", "New customer created successfully");
        return mav;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView mav = new ModelAndView("customer/update");
            mav.addObject("customer", customer.get());
            return mav;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView mav = new ModelAndView("/customer/update");
        mav.addObject("customer", customer);
        mav.addObject("message", "Customer updated successfully");
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView mav = new ModelAndView("/customer/delete");
            mav.addObject("customer", customer.get());
            return mav;
        } else{
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }

}
