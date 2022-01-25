package com.nttdata.customers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "Customer")
public class Customer {
    private String type;

    @Id
    private String id= UUID.randomUUID().toString();
    private String nationalId;
    private String name;
    private String phone;
}
