package by.bsuir.artemyev.service.impl;

import by.bsuir.artemyev.domain.InternalUserDto;
import by.bsuir.artemyev.domain.Order;
import by.bsuir.artemyev.service.NotificationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static Logger logger = LogManager.getLogger(NotificationServiceImpl.class);

    private final static String FROM = "ArtHotelSystem";
    private final static String SUCCESSFUL_BOOK_ROOM_SUBJECT = "Бронирование номера";

    @Autowired
    private MailSender mailSender;

    @Override
    public void notifyUserAboutCreatingOrder(InternalUserDto internalUserDto, Order order) {
        logger.info("Notify user: " + internalUserDto.toString() + " about book room");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(internalUserDto.getEmail());
        mailMessage.setFrom(FROM);
        mailMessage.setSubject(SUCCESSFUL_BOOK_ROOM_SUBJECT);
        mailMessage.setText(createMessage(internalUserDto, order));
        mailSender.send(mailMessage);
    }

    @Override
    public void notifyUserAboutDoneOrder(InternalUserDto internalUserDto, Order order) {
        logger.info("Notify user: " + internalUserDto.toString() + " about done book room ");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(internalUserDto.getEmail());
        mailMessage.setFrom(FROM);
        mailMessage.setSubject(SUCCESSFUL_BOOK_ROOM_SUBJECT);
        mailMessage.setText(createDoneMessage(internalUserDto, order));
        mailSender.send(mailMessage);
    }

    private String createDoneMessage(InternalUserDto user, Order order) {
        logger.info("Create notify message about done booking room");
        return "Уважаемый пользователь, " + user.getName() + ", Вы осуществили бронирование номера в отеле"
                + order.getHotel().getName() + ", находящегося по адресу: " + order.getHotel().getAddress()
                + "в период с " + order.getStartDate() +  "по " + order.getEndDate() + "c общей стоимостью: "
                + order.getOrderSuggestion().getFullPrice() + ". Ваша заявка обработана. Номер заявки:" + order.getId() + "Пожалуйста," +
                " для подтверждения бронирования свяжитесь с нашим оператором по телефону: +37533 - 679 - 76 - 61 "+ "Если, Вы, не осуществляли операцию бронирования, пожалуйста ответь нам на сообщение - сообщением: Не бронировал ";
    }

    private String createMessage(InternalUserDto user, Order order) {
        logger.info("Create notify message about booking room");
        return "Уважаемый пользователь, " + user.getName() + ", Вы осуществили бронирование номера в отеле"
                + order.getHotel().getName() + ", находящегося по адресу: " + order.getHotel().getAddress()
                + "в период с " + order.getStartDate() +  "по " + order.getEndDate() + "c общей стоимостью: "
                + order.getOrderSuggestion().getFullPrice() + ". Ваша заявка принята и находится в обработке. Номер заявки:" + order.getId() + "Пожалуйста, следите " +
                " за её статустом в разделе: Мои заказы. "+ "Если, Вы, не осуществляли операцию бронирования, пожалуйста ответь нам на сообщение - сообщением: Не бронировал ";
    }
}
