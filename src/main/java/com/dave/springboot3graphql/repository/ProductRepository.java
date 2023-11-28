package com.dave.springboot3graphql.repository;

import com.dave.springboot3graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product, UUID>
{
    List<Product> findAll();
    Product findProductByName(String name);

    Optional<Boolean> deleteProductById(UUID id);
}
