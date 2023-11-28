package com.dave.springboot3graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class ProductNotFoundException extends RuntimeException implements GraphQLError {

    private UUID productId;



    public ProductNotFoundException(UUID productId) {
        this.productId = productId;
    }



    @Override
    public String getMessage() {
        return "Product with ID " + productId + " could not be found";
    }



    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }



    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("productId", productId);
    }



    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
