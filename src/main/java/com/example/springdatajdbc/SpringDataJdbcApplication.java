package com.example.springdatajdbc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.springdatajdbc.repositories.OrderRepository;
import com.example.springdatajdbc.repositories.ProductRepository;
import com.example.springdatajdbc.service.Orders;
import com.example.springdatajdbc.service.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;


@SpringBootApplication
public class SpringDataJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }
    @Bean
    CommandLineRunner orderSave(OrderRepository
                                        orders){
        return args -> {
            orders.save(new Orders("Vasua", 90));
            orders.save(new Orders("Kolua", 110));
            orders.save(new Orders("Vlad", 140));
        };
    }

    @Bean
    CommandLineRunner orderGet(OrderRepository
                                       orders){
        return args -> {
            System.out.println(orders.findAll().size());
        };
    }


}


