package by.bsuir.artemyev.service;

import by.bsuir.artemyev.domain.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(String orderInfo);
    Order updateOrder(String orderInfo, String id);
    List<Order> getUserOrders(String userInfo);
    List<Order> getAllOrders();
    List<Order> getAllUnprocessedOrders();
}
