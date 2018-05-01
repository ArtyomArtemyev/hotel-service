package by.bsuir.artemyev.service.impl;

import by.bsuir.artemyev.client.SecurityServiceClient;
import by.bsuir.artemyev.domain.*;
import by.bsuir.artemyev.repository.HotelRepository;
import by.bsuir.artemyev.repository.OrderRepository;
import by.bsuir.artemyev.repository.TypeRoomRepository;
import by.bsuir.artemyev.service.NotificationService;
import by.bsuir.artemyev.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.UUID.randomUUID;

@Service
public class OrderServiceImpl implements OrderService {
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    private static final String TOKEN = "token";
    private static final String ACCESS_TOKEN = "accessToken";
    private static final String CITY = "city";
    private static final String COUNT_OF_MAN = "countOfMan";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String HOTEL = "hotel";
    private static final String ID = "id";
    private static final String TYPE_ROOM = "typeRoom";
    private static final String PRICE_FOR_ROOM = "priceForRoom";
    private static final String PRICE_FOR_DAY = "priceForDay";
    private static final String FULL_PRICE = "fullPrice";
    private static final String COUNT_ROOM = "countRoom";
    private static final String ORDER_SUGGESTION = "orderSuggestion";
    private static final String STATUS = "status";


    @Autowired
    private TypeRoomRepository typeRoomRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private SecurityServiceClient securityServiceClient;

    @Autowired
    private NotificationService notificationService;

    @Override
    public Order createOrder(String orderInfo) {
        String orderId = String.valueOf(randomUUID());
        JSONObject orderInfoJSONObject = new JSONObject(orderInfo);
        InternalUserDto internalUserDto = securityServiceClient.getUserByTokenContent(orderInfoJSONObject.getJSONObject(TOKEN).getString(ACCESS_TOKEN));
        Order order = new Order();
        order.setStatus(orderInfoJSONObject.getString(STATUS));
        order.setCountOfMan(orderInfoJSONObject.getInt(COUNT_OF_MAN));
        order.setCity(orderInfoJSONObject.getString(CITY));
        order.setInternalUser(internalUserDto);
        Date startDate = parseAndCreateDate(orderInfoJSONObject.getString(START_DATE));
        order.setStartDate(startDate);
        Date endDate = parseAndCreateDate(orderInfoJSONObject.getString(END_DATE));
        order.setEndDate(endDate);
        Hotel hotel = defineHotel(orderInfoJSONObject.getJSONObject(HOTEL).getString(ID));
        order.setHotel(hotel);
        OrderSuggestion orderSuggestion = new OrderSuggestion();
        orderSuggestion.setHotel(hotel);
        TypeRoom typeRoom = defineTypeRoom(orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getJSONObject(TYPE_ROOM).getString(ID));
        orderSuggestion.setTypeRoom(typeRoom);
        orderSuggestion.setPriceForRoom((float) orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getDouble(PRICE_FOR_ROOM));
        orderSuggestion.setPriceForDay((float) orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getDouble(PRICE_FOR_DAY));
        orderSuggestion.setFullPrice((float) orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getDouble(FULL_PRICE));
        orderSuggestion.setCountRoom(orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getInt(COUNT_ROOM));
        orderSuggestion.setServicePrices(Collections.emptyList());
        order.setOrderSuggestion(orderSuggestion);
        order.setId(orderId);
        orderRepository.save(order);
        notificationService.notifyUserAboutCreatingOrder(internalUserDto, order);
        return orderRepository.findOne(orderId);
    }

    @Override
    public Order updateOrder(String orderInfo, String id) {
        JSONObject orderInfoJSONObject = new JSONObject(orderInfo);
        InternalUserDto internalUserDto = securityServiceClient.getUserByTokenContent(orderInfoJSONObject.getJSONObject(TOKEN).getString(ACCESS_TOKEN));
        Order order = new Order();
        order.setStatus(orderInfoJSONObject.getString(STATUS));
        order.setCountOfMan(orderInfoJSONObject.getInt(COUNT_OF_MAN));
        order.setCity(orderInfoJSONObject.getString(CITY));
        order.setInternalUser(internalUserDto);
        Date startDate = parseAndCreateDate(orderInfoJSONObject.getString(START_DATE));
        order.setStartDate(startDate);
        Date endDate = parseAndCreateDate(orderInfoJSONObject.getString(END_DATE));
        order.setEndDate(endDate);
        Hotel hotel = defineHotel(orderInfoJSONObject.getJSONObject(HOTEL).getString(ID));
        order.setHotel(hotel);
        OrderSuggestion orderSuggestion = new OrderSuggestion();
        orderSuggestion.setHotel(hotel);
        TypeRoom typeRoom = defineTypeRoom(orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getJSONObject(TYPE_ROOM).getString(ID));
        orderSuggestion.setTypeRoom(typeRoom);
        orderSuggestion.setPriceForRoom((float) orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getDouble(PRICE_FOR_ROOM));
        orderSuggestion.setPriceForDay((float) orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getDouble(PRICE_FOR_DAY));
        orderSuggestion.setFullPrice((float) orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getDouble(FULL_PRICE));
        orderSuggestion.setCountRoom(orderInfoJSONObject.getJSONObject(ORDER_SUGGESTION).getInt(COUNT_ROOM));
        orderSuggestion.setServicePrices(Collections.emptyList());
        order.setOrderSuggestion(orderSuggestion);
        order.setId(id);
        orderRepository.delete(id);
        orderRepository.save(order);
        if(orderInfoJSONObject.getString(STATUS).equals("Обработана")) {
            notificationService.notifyUserAboutDoneOrder(internalUserDto, order);
        }
        return orderRepository.findOne(id);
    }

    @Override
    public List<Order> getUserOrders(String userInfo) {
        JSONObject userInfoJSONObject = new JSONObject(userInfo);
        InternalUserDto internalUserDto = securityServiceClient.getUserByTokenContent(userInfoJSONObject.getString(ACCESS_TOKEN));
        List<Order> userOrders = orderRepository.findAllByInternalUser(internalUserDto);
        return userOrders == null ? Collections.emptyList() : userOrders;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.size() == 0 ? Collections.emptyList() : orders;
    }

    @Override
    public List<Order> getAllUnprocessedOrders() {
        List<Order> unprocessedOrder = orderRepository.findAllByStatus("В ожидании обработки");
        return unprocessedOrder.size() == 0 ? Collections.emptyList() : unprocessedOrder;
    }

    private TypeRoom defineTypeRoom(String id) {
        return typeRoomRepository.findOne(id);
    }

    private Hotel defineHotel(String id) {
        return hotelRepository.findOne(id);
    }

    private Date parseAndCreateDate(String stringDate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = null;
        try {
            parseDate = formatter.parse(stringDate);
        } catch (ParseException e) {
            logger.error("Can not parse date: " + stringDate);
            e.printStackTrace();
        }
        return parseDate;
    }
}
