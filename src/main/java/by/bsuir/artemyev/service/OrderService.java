package by.bsuir.artemyev.service;

import by.bsuir.artemyev.domain.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(String orderInfo);
    List<Order> getUserOrders(String userInfo);
}
