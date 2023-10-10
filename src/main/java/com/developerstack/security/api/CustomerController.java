package com.developerstack.security.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping("/user")
    public String createCustomer(){
        return "createCustomer";
    }

    @PutMapping("/user")
    public String updateCustomer(){
        return "updateCustomer";
    }

    @DeleteMapping("/user")
    public String deleteCustomer(){
        return "deleteCustomer";
    }

    @GetMapping("/user")
    public String findCustomer(){
        return "findCustomer";
    }

    @GetMapping( "user/list")
    public String findAllCustomer(){
        return "findAllCustomer";
    }

}
