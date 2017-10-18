package com.company.burger.service;

import com.company.burger.entity.Order;
import com.company.burger.entity.OrderItem;
import com.company.burger.entity.OrderStatus;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.haulmont.bali.util.Preconditions.checkNotNullArgument;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {
    @Inject
    private Metadata metadata;
    @Inject
    private DataManager dataManager;
    @Inject
    private UserSessionSource userSessionSource;

    @Override
    public Order placeOrder(List<OrderItem> items) {
        Order order = metadata.create(Order.class);
        User currentUser = userSessionSource.getUserSession().getCurrentOrSubstitutedUser();
        order.setUser(currentUser);
        order.setStatus(OrderStatus.COOKING);
        items.forEach(item -> item.setOrder(order));

        CommitContext commitContext = new CommitContext(items).addInstanceToCommit(order);

        Set<Entity> resultSet = dataManager.commit(commitContext);

        Entity entity = resultSet.stream()
                .filter(e -> e instanceof Order)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to retrieve created order"));

        return (Order) entity;
    }

    @Override
    public void cancelOrder(UUID orderId) {
        checkNotNullArgument(orderId);

        Order order = dataManager.load(LoadContext.create(Order.class)
                .setId(orderId)
                .setView(View.LOCAL));
        if (order != null) {
            order.setStatus(OrderStatus.CANCELED);
            dataManager.commit(order);
        } else {
            throw new RuntimeException("Order with id '" + orderId + "' not found");
        }
    }
}