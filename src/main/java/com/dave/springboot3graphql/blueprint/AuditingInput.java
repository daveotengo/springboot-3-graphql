package com.dave.springboot3graphql.blueprint;


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditingInput {


    private String createdBy;


    private LocalDateTime createdAt;


    private String updatedBy;


    private LocalDateTime updatedAt;



}
