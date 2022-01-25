package com.nttdata.customers.service;

import com.nttdata.customers.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> listCustomers();

    Mono<Customer> listById(String id);

    Mono<Void> removeCustomer(String id);

    Mono<Customer> saveCustomer(Customer customer);

    Mono<Customer> updateCustomer(Customer customer);
}
