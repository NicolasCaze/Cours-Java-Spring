package com.ynov.ai.service;

import com.ynov.ai.Repository.ProductCategoryRepo;
import com.ynov.ai.Repository.ProductRepo;
import com.ynov.ai.entity.Product;
import com.ynov.ai.entity.Product_Category;
import dto.ProductCategoryDTO;
import dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    public Product_Category createProductCategory(ProductCategoryDTO productCategoryDTO){
        Product_Category category = new Product_Category();
        category.setCategory(productCategoryDTO.category());
        category.setCategory(productCategoryDTO.description());

        List<Product> products = new ArrayList<>();
        for (ProductDTO productDTO : productCategoryDTO.products()) {
            Product product = new Product();
            product.setName(productDTO.name());
            product.setImage(productDTO.image());
            product.setProduct_category(category);
            products.add(product);
        }
        category.setProducts(products);
        return productCategoryRepo.save(category);
    }
}
