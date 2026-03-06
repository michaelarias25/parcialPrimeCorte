package com.parcial.parcial.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int stock;
}
