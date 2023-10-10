package com.developerstack.security.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @PostMapping()
    public String createProduct(){
        return "createProduct";
    }

    public String updateProduct(){
        return "updateProduct";
    }

    public String deleteProduct(){
        return "deleteProduct";
    }

    @GetMapping("/user")
    public String findProduct(){
        return "findProduct";
    }

    @GetMapping( "user/list")
    public String findAllProduct(){
        return "findAllProduct";
    }

}
