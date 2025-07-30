package com.example.raspberriesSellerService.controller;

import com.example.raspberriesSellerService.model.Seller;
import com.example.raspberriesSellerService.repository.SellerRepository;
import com.example.raspberriesSellerService.service.SellerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("sellers")
    public ResponseEntity<Page<Seller>> getAllSellers(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getAllSellers(page, size));
    }

    @GetMapping("seller/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getSellerById(id));
    }
}
