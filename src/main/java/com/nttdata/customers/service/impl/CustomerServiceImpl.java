package com.nttdata.customers.service.impl;

import com.nttdata.customers.model.Customer;
import com.nttdata.customers.repository.CustomerRepository;
import com.nttdata.customers.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Flux<Customer> listCustomers() {
        log.info("Listing all customers");
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> listById(String id) {
        log.info("Listing customer with id"+id);
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Void> removeCustomer(String id) {
        log.info("Removing Customer with Id"+ id);
        return customerRepository.deleteById(id);
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer) {
        if (customer.getId().isEmpty()) {customer.setId(UUID.randomUUID().toString());
        log.info("Inserting customer with created ID "+customer.getId());}
        else
            log.info("Inserting customer with ID "+customer.getId());

        return customerRepository.insert(customer);
    }

    @Override
    public Mono<Customer> updateCustomer(Customer customer) {
        log.info("Updating customer "+ customer.getId());
        return customerRepository.save(customer);
    }
}
