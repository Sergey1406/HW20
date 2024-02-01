package com.example.springdatajdbc.controller;

import com.example.springdatajdbc.repositories.OrderRepository;
import com.example.springdatajdbc.service.Orders;
import lombok.Builder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class OrderControllerMockMvcTest {


    @Autowired
    private TestRestTemplate restTemplate;


    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void shouldGetOrderById(){

        Orders order = new Orders("DDDdddd", 15);
        Orders saveOrders = orderRepository.save(order);
        Orders result = restTemplate.getForObject("http://localhost:8080" +
                "/order/" + saveOrders.getId(), Orders.class);

        Assertions.assertEquals(saveOrders.getId(), result.getId());
    }

    @Test
    public void shouldDeleteById(){
        orderRepository.deleteById(3);
        Assertions.assertTrue(orderRepository.findById(3).isEmpty());
        restTemplate.getForObject("http://localhost:8080" +
                "/orders/" + 3, Orders.class);


    }

}