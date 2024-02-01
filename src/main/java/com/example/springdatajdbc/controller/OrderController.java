package com.example.springdatajdbc.controller;
import java.util.List;

import com.example.springdatajdbc.repositories.OrderRepository;
import com.example.springdatajdbc.service.Orders;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;

    @GetMapping("/order")
    public Iterable<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Orders getOrderById(@PathVariable("id") Integer id){
        return orderRepository.findById(id).get();
    }

    @GetMapping("/orders/{id}")
    public void deleteOrderById(@PathVariable("id") Integer id){
        orderRepository.deleteById(id);
    }
}
