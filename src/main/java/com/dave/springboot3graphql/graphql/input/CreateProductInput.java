package com.dave.springboot3graphql.graphql.input;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateProductInput {
    private String name;
    private int stock;
    private float price;
}
