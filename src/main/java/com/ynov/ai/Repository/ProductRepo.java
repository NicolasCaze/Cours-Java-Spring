package com.ynov.ai.Repository;

import com.ynov.ai.entity.Product;
import com.ynov.ai.entity.Product_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
