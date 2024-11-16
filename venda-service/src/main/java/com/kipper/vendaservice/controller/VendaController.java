package com.kipper.vendaservice.controller;

import com.kipper.vendaservice.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @PostMapping
    public ResponseEntity<Void> realizarVenda(@RequestBody Product produto){

        //atualiza o estoque do produto enviando esse ID para o topic "estoque-topico"
        kafkaTemplate.send("estoque-topico", produto);

        return ResponseEntity.ok().build();
    }

}
