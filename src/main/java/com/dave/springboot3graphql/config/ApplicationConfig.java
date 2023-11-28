package com.dave.springboot3graphql.config;



import com.dave.springboot3graphql.exception.GraphQLErrorAdapter;
import com.dave.springboot3graphql.model.Product;
import com.dave.springboot3graphql.repository.ProductRepository;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {


  @Bean
  public GraphQLErrorHandler errorHandler() {
    return new GraphQLErrorHandler() {
      @Override
      public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        List<GraphQLError> clientErrors = errors.stream()
                .filter(this::isClientError)
                .collect(Collectors.toList());

        List<GraphQLError> serverErrors = errors.stream()
                .filter(e -> !isClientError(e))
                .map(GraphQLErrorAdapter::new)
                .collect(Collectors.toList());

        List<GraphQLError> e = new ArrayList<>();
        e.addAll(clientErrors);
        e.addAll(serverErrors);
        return e;
      }



      protected boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
      }
    };
  }


  @Bean
  public CommandLineRunner commandLineRunner(
          ProductRepository productRepository
  ) {
    return args -> {


      // Create two products
      String productA="Product A";
      String productB="Product B";

      Product product1 = Product.builder()
              .name(productA)
              .price(Double.valueOf(20.0))
              .stock(50)
              .build();

      Product product2 = Product.builder()
              .name(productB)
              .price(Double.valueOf(30.0))
              .stock(30)
              .build();

      productRepository.saveAll(List.of(product1, product2));

      Product product= productRepository.findProductByName(productA);
      Product productBObject= productRepository.findProductByName(productB);

    };
  }


}
