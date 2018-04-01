package by.bsuir.artemyev.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "user_orders")
public class Order implements Serializable, Cloneable {

    @Id
    private String id;
    private Hotel hotel;
    private String city;
    private Date startDate;
    private Date endDate;
    private Integer countOfMan;
    private OrderSuggestion orderSuggestion;

    @JsonProperty("user")
    private InternalUserDto internalUser;
    private String status;

    public Order() {
        super();
    }

    public Order(String id, Hotel hotel, String city, Date startDate, Date endDate, Integer countOfMan, OrderSuggestion orderSuggestion, InternalUserDto internalUser, String status) {
        this.id = id;
        this.hotel = hotel;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.countOfMan = countOfMan;
        this.orderSuggestion = orderSuggestion;
        this.internalUser = internalUser;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountOfMan() {
        return countOfMan;
    }

    public void setCountOfMan(Integer countOfMan) {
        this.countOfMan = countOfMan;
    }

    public OrderSuggestion getOrderSuggestion() {
        return orderSuggestion;
    }

    public void setOrderSuggestion(OrderSuggestion orderSuggestion) {
        this.orderSuggestion = orderSuggestion;
    }

    public InternalUserDto getInternalUser() {
        return internalUser;
    }

    public void setInternalUser(InternalUserDto internalUser) {
        this.internalUser = internalUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(hotel, order.hotel) &&
                Objects.equals(city, order.city) &&
                Objects.equals(startDate, order.startDate) &&
                Objects.equals(endDate, order.endDate) &&
                Objects.equals(countOfMan, order.countOfMan) &&
                Objects.equals(orderSuggestion, order.orderSuggestion) &&
                Objects.equals(internalUser, order.internalUser) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotel, city, startDate, endDate, countOfMan, orderSuggestion, internalUser, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", hotel=" + hotel +
                ", city='" + city + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", countOfMan=" + countOfMan +
                ", orderSuggestion=" + orderSuggestion +
                ", internalUser=" + internalUser +
                ", status='" + status + '\'' +
                '}';
    }
}
