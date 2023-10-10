package com.developerstack.security.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @PostMapping("/user")
    public String createOrder(){
        return "createOrder";
    }

    @PutMapping("/user")
    public String updateOrder(){
        return "updateOrder";
    }

    @DeleteMapping("/user")
    public String deleteOrder(){
        return "deleteOrder";
    }


    @GetMapping
    public String findOrder(){
        return "findOrder";
    }

    @GetMapping
    public String findAllOrder(){
        return "findAllOrder";
    }
}
