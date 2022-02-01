package com.nttdata.customers.service.impl;


import com.nttdata.customers.model.Card;
import com.nttdata.customers.repository.CardRepository;
import com.nttdata.customers.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    Logger log = LoggerFactory.getLogger(CardService.class);

    @Autowired
    CardRepository cardRepository;


    @Override
    public Mono<Card> listById(String id) {
        log.info("Listing customer with id"+id);
        return cardRepository.findById(id);
    }

    @Override
    public Flux<Card> listByOwnerId(String ownerId) {
        return cardRepository.findCardByOwnerId(ownerId);
    }

    @Override
    public Mono<Void> removeCard(String id) {
        log.info("Removing Customer with Id"+ id);
        return cardRepository.deleteById(id);
    }

    @Override
    public Mono<Card> saveCard(Card card) {
        if (card.getId().isEmpty()) {card.setId(UUID.randomUUID().toString());
        log.info("Inserting customer with created ID "+card.getId());}
        else
            log.info("Inserting card with ID "+ card.getId());

        return cardRepository.insert(card);
    }

    @Override
    public Mono<Card> updateCard(Card card) {
        log.info("Updating customer "+ card.getId());
        return cardRepository.save(card);
    }

    @Override
    public Flux<Card> listCreditByOwner(String ownerId) {
        return cardRepository.findCardByOwnerId(ownerId).filter(value -> {
            if (value.getType().equals("Credit")) return true;
            else return false;
        });
    }
}
