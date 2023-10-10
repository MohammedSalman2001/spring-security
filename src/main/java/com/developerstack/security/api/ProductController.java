package com.developerstack.security.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/api/v1/products")
public class ProductController {
    @PostMapping
    public String createProduct(){
        return "createProduct";
    }

    @PutMapping
    public String updateProduct(){
        return "updateProduct";
    }

    @DeleteMapping
    public String deleteProduct(){
        return "deleteProduct";
    }

    @GetMapping
    public String findProduct(){
        return "findProduct";
    }

    @GetMapping( "list")
    public String findAllProduct(){
        return "findAllProduct";
    }

}
