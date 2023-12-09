package com.dave.springboot3graphql.graphql.schema;



import com.dave.springboot3graphql.exception.ProductNotFoundException;
import com.dave.springboot3graphql.graphql.input.CreateProductInput;
import com.dave.springboot3graphql.graphql.input.UpdateProductInput;
import com.dave.springboot3graphql.graphql.output.DeletionStatus;
import com.dave.springboot3graphql.model.Product;
import com.dave.springboot3graphql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Transactional(readOnly = true)
    @QueryMapping
    public List<Product> getAllProducts() {
        logger.info("Getting all products...");

        List<Product> products = productRepository.findAll();

        logger.info("Retrieved {} products: {}", products.size(), products);

        return products;
    }


    @QueryMapping
    //product(id: Long!): Product
    public Product getProductById(@Argument UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


    // addProduct(name: String!, rating: Float) : Product!
    @Transactional
    @MutationMapping
    public Product createProduct(@Argument CreateProductInput input) {
        String name = input.getName();
        int stock = input.getStock();
        double price = input.getPrice();
        logger.info("Creating product: name={}, stock={}, price={}", name, stock, price);

        try {
            // Extract values from input


            // Create a new Product
            Product newProduct = new Product(name, stock, price);
            Product savedProduct = productRepository.saveAndFlush(newProduct);
            logger.info("Product created successfully: {}", savedProduct);
            return savedProduct;
        } catch (Exception e) {
            logger.error("Error creating product", e);
            throw e; // Rethrow the exception to propagate it to the caller
        }
    }



    // updateProductRating(id: ID!, rating: Float!) : Product!
    @Transactional
    @MutationMapping
    public Product updateProduct(@Argument UpdateProductInput input) {

        UUID id = input.getId();
        int stock = input.getStock();
        double price = input.getPrice();

        Product product = getProductById(id);
        product.setPrice(price);
        product.setStock(stock);
        return productRepository.save(product);

    }





    // deleteOrder(id: ID!) : UUID!
    @Transactional
    @MutationMapping
    public DeletionStatus deleteProduct(@Argument UUID id) {

        logger.info("product with id: {} being deleted",id);

            if (!productRepository.existsById(id)) {
                logger.info("product with id: {} not found",id);
                return new DeletionStatus(false, "Product not found");
            }
            productRepository.deleteById(id);
        logger.info("product with id: {} deleted successfully",id);
        return new DeletionStatus(true, "Product deleted successfully");

    }



}
