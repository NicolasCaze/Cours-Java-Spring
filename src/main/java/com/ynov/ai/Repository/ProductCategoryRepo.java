package com.ynov.ai.Repository;

import com.ynov.ai.entity.Product_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<Product_Category, Long> {
}
