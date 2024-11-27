package com.ynov.ai.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    String name;
    Integer quantity;
    String image;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Category_id")
    private Product_Category product_category;

}