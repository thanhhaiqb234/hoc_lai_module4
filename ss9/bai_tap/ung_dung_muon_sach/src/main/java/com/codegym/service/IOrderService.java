package com.codegym.service;

import com.codegym.model.Books;
import com.codegym.model.Orders;

public interface IOrderService {
    void createOrder(Orders orders);

    Orders getOrder(String borrowcCode);

    void returnsBook(Orders orders);
}
