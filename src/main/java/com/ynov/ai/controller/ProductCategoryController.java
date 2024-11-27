package com.ynov.ai.controller;

import com.ynov.ai.entity.Product_Category;
import com.ynov.ai.service.ProductCategoryService;
import dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping(path="create")
    public Product_Category createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO){
        return productCategoryService.createProductCategory(productCategoryDTO);
    }
}
