package com.example.raspberriesSellerService.dto;

import lombok.Getter;

@Getter
public class SellerRegisteredEvent {
    private Long id;
    private String name;
    private String taxId;

    public SellerRegisteredEvent(){}
    public SellerRegisteredEvent(Long id, String name, String taxId) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
    }
}
