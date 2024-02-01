package com.example.springdatajdbc.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@Getter
@Table
@Entity

public class Product {
    @jakarta.persistence.Id
    @GeneratedValue
    private Integer id;
    private Integer orders_id;
    private int cost;
    private String name;


}
