package by.bsuir.artemyev.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class OrderSuggestion implements Serializable, Cloneable {
    private Hotel hotel;
    private TypeRoom typeRoom;
    private Float priceForRoom;
    private Float priceForDay;
    private Float fullPrice;
    private Integer countRoom;
    private List<ServicePrice> servicePrices;

    public OrderSuggestion() {
        super();
    }

    public OrderSuggestion(Hotel hotel, TypeRoom typeRoom, Float priceForRoom, Float priceForDay, Float fullPrice, Integer countRoom, List<ServicePrice> servicePrices) {
        this.hotel = hotel;
        this.typeRoom = typeRoom;
        this.priceForRoom = priceForRoom;
        this.priceForDay = priceForDay;
        this.fullPrice = fullPrice;
        this.countRoom = countRoom;
        this.servicePrices = servicePrices;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public Float getPriceForRoom() {
        return priceForRoom;
    }

    public void setPriceForRoom(Float priceForRoom) {
        this.priceForRoom = priceForRoom;
    }

    public Float getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(Float priceForDay) {
        this.priceForDay = priceForDay;
    }

    public Float getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(Float fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Integer getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(Integer countRoom) {
        this.countRoom = countRoom;
    }

    public List<ServicePrice> getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(List<ServicePrice> servicePrices) {
        this.servicePrices = servicePrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSuggestion that = (OrderSuggestion) o;
        return Objects.equals(hotel, that.hotel) &&
                Objects.equals(typeRoom, that.typeRoom) &&
                Objects.equals(priceForRoom, that.priceForRoom) &&
                Objects.equals(priceForDay, that.priceForDay) &&
                Objects.equals(fullPrice, that.fullPrice) &&
                Objects.equals(countRoom, that.countRoom) &&
                Objects.equals(servicePrices, that.servicePrices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, typeRoom, priceForRoom, priceForDay, fullPrice, countRoom, servicePrices);
    }

    @Override
    public String toString() {
        return "OrderSuggestion{" +
                "hotel=" + hotel +
                ", typeRoom=" + typeRoom +
                ", priceForRoom=" + priceForRoom +
                ", priceForDay=" + priceForDay +
                ", fullPrice=" + fullPrice +
                ", countRoom=" + countRoom +
                ", servicePrices=" + servicePrices +
                '}';
    }
}
