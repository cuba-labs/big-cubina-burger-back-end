package com.company.burger.service;


import com.company.burger.entity.Order;
import com.company.burger.entity.OrderItem;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    String NAME = "burger_OrderService";

    Order placeOrder(List<OrderItem> items);

    void cancelOrder(UUID orderId);
}