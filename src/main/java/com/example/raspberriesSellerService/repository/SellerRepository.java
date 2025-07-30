package com.example.raspberriesSellerService.repository;

import com.example.raspberriesSellerService.model.Seller;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    @NotNull
    public Optional<Seller> findById(@NotNull Long id);
}
