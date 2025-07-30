package com.example.raspberriesSellerService.service;

import com.example.raspberriesSellerService.dto.SellerRegisteredEvent;
import com.example.raspberriesSellerService.model.Seller;
import com.example.raspberriesSellerService.repository.SellerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @KafkaListener(topics="seller-registered")
    public void handleSellerRegistrationEvent(List<ConsumerRecord<Long,String>> records, Acknowledgment ack) throws JsonProcessingException {
        List<Seller> sellersToSave=new ArrayList<>();
        for (ConsumerRecord<Long,String> record : records) {
            var event=objectMapper.readValue(record.value(), SellerRegisteredEvent.class);
            if(sellerRepository.findById(event.getId()).isEmpty()){
                sellersToSave.add(new Seller(event.getId(),event.getName(),event.getTaxId()));
                System.out.println("Created seller with id "+event.getId());
            }
        }
        if(!sellersToSave.isEmpty()){
            sellerRepository.saveAll(sellersToSave);
        }
    }

    public Page<Seller> getAllSellers(int page, int size){
        return sellerRepository.findAll(PageRequest.of(page,size));
    }

    public Seller getSellerById(Long id){
        return sellerRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Seller not found"));
    }
}
