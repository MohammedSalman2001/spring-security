package com.developerstack.security.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    @PreAuthorize("hasAuthority('product_write')")
    public String createCustomer(){
        return "createCustomer";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('product_write')")
    public String updateCustomer(){
        return "updateCustomer";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('product_write')")
    public String deleteCustomer(){
        return "deleteCustomer";
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    public String findCustomer(){
        return "findCustomer";
    }

    @GetMapping( "list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    public String findAllCustomer(){
        return "findAllCustomer";
    }

}
