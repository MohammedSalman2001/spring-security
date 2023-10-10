package com.developerstack.security.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @PostMapping
    public String createOrder(){
        return "createOrder";
    }


   @PutMapping
    public String updateOrder(){
        return "updateOrder";
    }

    @DeleteMapping
    public String deleteOrder(){
        return "deleteOrder";
    }

    @GetMapping()
    public String findOrder(){
        return "findOrder";
    }

    @GetMapping("/list")
    public String findAllOrder(){
        return "findAllOrder";
    }

}
