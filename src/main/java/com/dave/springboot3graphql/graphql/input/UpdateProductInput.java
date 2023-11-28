package com.dave.springboot3graphql.graphql.input;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateProductInput {
    private UUID id;
    private int stock;
    private float price;
}
