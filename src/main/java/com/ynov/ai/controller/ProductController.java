package com.ynov.ai.controller;

import com.ynov.ai.entity.Product;
import com.ynov.ai.service.ServiceProduct;
import dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/product")
public class ProductController {

    @Autowired
    private ServiceProduct serviceProduct;


    @PostMapping(path="/create")
    public Product createProduct(@RequestBody ProductDTO productDTO){
        return serviceProduct.createProduct(productDTO);
    }
}
