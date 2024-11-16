package com.kipper.vendaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<Void> realizarVenda(@RequestBody String idDoProduto){

        //atualiza o estoque do produto enviando esse ID para o topic "estoque-topico"
        kafkaTemplate.send("estoque-topico", idDoProduto);

        return ResponseEntity.ok().build();
    }

}
