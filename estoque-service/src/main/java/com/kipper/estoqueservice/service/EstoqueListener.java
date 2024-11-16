package com.kipper.estoqueservice.service;

import com.kipper.estoqueservice.entities.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EstoqueListener {
    @KafkaListener(topics = "estoque-topico", groupId = "estoque-group")
    public void processarVenda(Product product) {
        System.out.println("Venda recebida: " + product.getId());
    }
}

