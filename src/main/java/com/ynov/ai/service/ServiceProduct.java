package com.ynov.ai.service;

import com.ynov.ai.Repository.ProductCategoryRepo;
import com.ynov.ai.Repository.ProductRepo;
import com.ynov.ai.entity.Product;
import com.ynov.ai.entity.Product_Category;
import dto.ProductCategoryDTO;
import dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduct {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    public Product createProduct(ProductDTO productDTO){
        Product_Category category = new Product_Category();
        category.setCategory(productDTO.category());
        category.setCategory(productDTO.description());

        Product product = new Product();
        product.setName(productDTO.name());
        product.setProduct_category(category);

        return productRepo.save(product);
    }

}
