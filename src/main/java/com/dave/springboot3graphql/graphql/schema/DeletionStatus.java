package com.dave.springboot3graphql.graphql.schema;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public  class DeletionStatus {
    private boolean success;
    private String message;
}
