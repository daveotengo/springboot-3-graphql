package com.dave.springboot3graphql.model;

import com.dave.springboot3graphql.blueprint.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product extends BaseEntity {

    @Column(unique = true)
    private String name;
    private int stock;
    private double price;
}
