package by.bsuir.artemyev.service;

import by.bsuir.artemyev.domain.InternalUserDto;
import by.bsuir.artemyev.domain.Order;

public interface NotificationService {
    void notifyUserAboutCreatingOrder(InternalUserDto internalUserDto, Order order);
    void notifyUserAboutDoneOrder(InternalUserDto internalUserDto, Order order);
}
