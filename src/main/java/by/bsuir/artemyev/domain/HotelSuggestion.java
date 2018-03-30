package by.bsuir.artemyev.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HotelSuggestion implements Serializable, Cloneable {
    private Hotel hotel;
    private List<OrderSuggestion> orderSuggestions;

    public HotelSuggestion() {
        super();
    }

    public HotelSuggestion(Hotel hotel, List<OrderSuggestion> orderSuggestions) {
        this.hotel = hotel;
        this.orderSuggestions = orderSuggestions;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<OrderSuggestion> getOrderSuggestions() {
        return orderSuggestions;
    }

    public void setOrderSuggestions(List<OrderSuggestion> orderSuggestions) {
        this.orderSuggestions = orderSuggestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelSuggestion that = (HotelSuggestion) o;
        return Objects.equals(hotel, that.hotel) &&
                Objects.equals(orderSuggestions, that.orderSuggestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, orderSuggestions);
    }

    @Override
    public String toString() {
        return "HotelSuggestion{" +
                "hotel=" + hotel +
                ", orderSuggestions=" + orderSuggestions +
                '}';
    }
}
