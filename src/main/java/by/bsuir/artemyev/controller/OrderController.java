package by.bsuir.artemyev.controller;

import by.bsuir.artemyev.domain.Order;
import by.bsuir.artemyev.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private static Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order createOrder(@RequestBody String orderInfo) {
        logger.info("Request to create order with order info: " + orderInfo + "and token: ");
        return orderService.createOrder(orderInfo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody String orderInfo, @PathVariable("id") String id) {
        logger.info("Request to update order with order info: " + orderInfo + "and token: ");
        return orderService.updateOrder(orderInfo, id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<Order> getOrdersForUser(@RequestBody String userInfo) {
        logger.info("Request to get orders for user with user info:" + userInfo);
        return orderService.getUserOrders(userInfo);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getAllOrders() {
        logger.info("Request to get all orders");
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/unprocessed", method = RequestMethod.GET)
    public List<Order> getAllUnprocessedOrders() {
        logger.info("Request to get all unprocessed orders");
        return orderService.getAllUnprocessedOrders();
    }
}
