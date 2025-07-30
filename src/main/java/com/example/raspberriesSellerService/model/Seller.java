package com.example.raspberriesSellerService.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="sellers")
public class Seller {
    @Id
    private Long id;
    private String logo;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String taxId;
    @CreationTimestamp
    private LocalDateTime registrationDate;

    public Seller() {}
    public Seller(Long id, String name, String taxId) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
    }
}
