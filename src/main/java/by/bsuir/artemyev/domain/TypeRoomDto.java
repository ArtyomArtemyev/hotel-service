package by.bsuir.artemyev.domain;

import java.io.Serializable;
import java.util.Objects;

public class TypeRoomDto implements Serializable, Cloneable {
    private String id;
    private String hotelId;
    private Integer countOfBed;
    private Integer typeOfBed;
    private Integer countOfChildBed;
    private Float priceForChildBed;
    private Float price;

    public TypeRoomDto() {
        super();
    }

    public TypeRoomDto(String id, String hotelId, Integer countOfBed, Integer typeOfBed, Integer countOfChildBed, Float priceForChildBed, Float price) {
        this.id = id;
        this.hotelId = hotelId;
        this.countOfBed = countOfBed;
        this.typeOfBed = typeOfBed;
        this.countOfChildBed = countOfChildBed;
        this.priceForChildBed = priceForChildBed;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getCountOfBed() {
        return countOfBed;
    }

    public void setCountOfBed(Integer countOfBed) {
        this.countOfBed = countOfBed;
    }

    public Integer getTypeOfBed() {
        return typeOfBed;
    }

    public void setTypeOfBed(Integer typeOfBed) {
        this.typeOfBed = typeOfBed;
    }

    public Integer getCountOfChildBed() {
        return countOfChildBed;
    }

    public void setCountOfChildBed(Integer countOfChildBed) {
        this.countOfChildBed = countOfChildBed;
    }

    public Float getPriceForChildBed() {
        return priceForChildBed;
    }

    public void setPriceForChildBed(Float priceForChildBed) {
        this.priceForChildBed = priceForChildBed;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeRoomDto that = (TypeRoomDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(hotelId, that.hotelId) &&
                Objects.equals(countOfBed, that.countOfBed) &&
                Objects.equals(typeOfBed, that.typeOfBed) &&
                Objects.equals(countOfChildBed, that.countOfChildBed) &&
                Objects.equals(priceForChildBed, that.priceForChildBed) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelId, countOfBed, typeOfBed, countOfChildBed, priceForChildBed, price);
    }

    @Override
    public String toString() {
        return "TypeRoomDto{" +
                "id='" + id + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", countOfBed=" + countOfBed +
                ", typeOfBed=" + typeOfBed +
                ", countOfChildBed=" + countOfChildBed +
                ", priceForChildBed=" + priceForChildBed +
                ", price=" + price +
                '}';
    }
}
