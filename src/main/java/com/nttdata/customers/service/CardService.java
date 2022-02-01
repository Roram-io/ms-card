package com.nttdata.customers.service;

import com.nttdata.customers.model.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {

    Mono<Card> listById(String id);
    Flux<Card> listByOwnerId(String ownerId);
    Mono<Void> removeCard(String id);
    Mono<Card> saveCard(Card card);
    Mono<Card> updateCard(Card card);

    Flux<Card> listCreditByOwner(String ownerId);


}
