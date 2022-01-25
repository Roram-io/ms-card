package com.nttdata.customers.controller;

import com.nttdata.customers.model.Customer;
import com.nttdata.customers.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/card")
public class CustomerController {

    Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping
    public Flux<Customer> getCustomers(){
        log.info("Listing all customers: ");
        return customerService.listCustomers();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomerById(@PathVariable("id") String id){
        log.info("Searching customer with Id "+id);
        return customerService.listById(id);
    }

    @PostMapping("/save")
    public Mono<Customer> saveCustomer(@RequestBody Customer customer){
        log.info("Inserting a new customer");
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/update")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer){
        log.info("Updating the following Id: "+customer.getId());
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> removeCustomer(@PathVariable("id") String id){
        log.info("Removing the following Customer: "+ id);
        return customerService.removeCustomer(id);
    }


}
