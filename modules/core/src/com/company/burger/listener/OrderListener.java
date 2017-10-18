package com.company.burger.listener;

import com.company.burger.entity.Order;
import com.company.burger.entity.OrderStatus;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

@Component("burger_OrderListener")
public class OrderListener implements BeforeInsertEntityListener<Order> {

    @Override
    public void onBeforeInsert(Order entity, EntityManager entityManager) {
        if (entity.getStatus() == null) {
            entity.setStatus(OrderStatus.COOKING);
        }
    }
}