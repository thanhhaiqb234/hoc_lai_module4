package com.codegym.service;

import com.codegym.model.Books;
import com.codegym.model.Orders;
import com.codegym.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public void createOrder(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public Orders getOrder(String borrowcCode) {
        return orderRepository.getReturnsBook(borrowcCode);
    }

    @Override
    public void returnsBook(Orders orders) {
        orderRepository.delete(orders);
    }
}
