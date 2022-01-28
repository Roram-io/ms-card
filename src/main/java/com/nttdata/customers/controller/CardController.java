package com.nttdata.customers.controller;

import com.nttdata.customers.model.Card;
import com.nttdata.customers.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    Logger log = LoggerFactory.getLogger(CardController.class);

    @Autowired
    CardService cardService;

    @GetMapping("/owner/{id}")
    public Flux<Card> getCardsByOwnerId(@PathVariable("id") String id){
        log.info("Listing all cards by Id:  "+id);
        return cardService.listByOwnerId(id);
    }

    @GetMapping("/{id}")
    public Mono<Card> getCardById(@PathVariable("id") String id){
        log.info("Searching card with Id "+id);
        return cardService.listById(id);
    }

    @PostMapping("/save")
    public Mono<Card> saveCard(@RequestBody Card card){
        log.info("Inserting a new card");
        return cardService.saveCard(card);
    }

    @PutMapping("/update")
    public Mono<Card> updateCard(@RequestBody Card card){
        log.info("Updating the following Id: "+ card.getId());
        return cardService.updateCard(card);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> removeCustomer(@PathVariable("id") String id){
        log.info("Removing the following Card: "+ id);
        return cardService.removeCard(id);
    }


}
