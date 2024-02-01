package com.example.springdatajdbc.service;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;



@Setter
@Getter
@Table
@Entity
public class Orders {


    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer cost;

    public Orders(String name, Integer cost){
        this.name = name;
        this.cost = cost;
    }


    public Orders() {

    }


}
