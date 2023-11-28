package com.dave.springboot3graphql.blueprint;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditingEntity  {

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    public void setUpCreateDate() {
        createdAt = LocalDateTime.now();
        // Get the current user's username from the SecurityContext
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if(auth!=null) {
//            String name = auth.getName();
//            if (name != null) {
//                createdBy = name;
//            } else {
//                // Handle the case where the principal is not a UserDetails
//                createdBy = "Unknown"; // Set a default value or handle it as needed
//            }
//        }
    }
}
