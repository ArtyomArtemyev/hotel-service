package by.bsuir.artemyev.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "type_rooms")
public class TypeRoom implements Serializable, Cloneable {

    @Id
    private String id;
    private String hotelId;
    private Integer countOfMainBed;
    private Integer typeOfMainBed;
    private Integer countOfChildBed;
    private Float priceForOneChildBed;
    private Float priceForDay;

    public TypeRoom() {
        super();
    }

    public TypeRoom(String id, String hotelId, Integer countOfMainBed, Integer typeOfMainBed, Integer countOfChildBed, Float priceForOneChildBed, Float priceForDay) {
        this.id = id;
        this.hotelId = hotelId;
        this.countOfMainBed = countOfMainBed;
        this.typeOfMainBed = typeOfMainBed;
        this.countOfChildBed = countOfChildBed;
        this.priceForOneChildBed = priceForOneChildBed;
        this.priceForDay = priceForDay;
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

    public Integer getCountOfMainBed() {
        return countOfMainBed;
    }

    public void setCountOfMainBed(Integer countOfMainBed) {
        this.countOfMainBed = countOfMainBed;
    }

    public Integer getTypeOfMainBed() {
        return typeOfMainBed;
    }

    public void setTypeOfMainBed(Integer typeOfMainBed) {
        this.typeOfMainBed = typeOfMainBed;
    }

    public Integer getCountOfChildBed() {
        return countOfChildBed;
    }

    public void setCountOfChildBed(Integer countOfChildBed) {
        this.countOfChildBed = countOfChildBed;
    }

    public Float getPriceForOneChildBed() {
        return priceForOneChildBed;
    }

    public void setPriceForOneChildBed(Float priceForOneChildBed) {
        this.priceForOneChildBed = priceForOneChildBed;
    }

    public Float getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(Float priceForDay) {
        this.priceForDay = priceForDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeRoom typeRoom = (TypeRoom) o;
        return Objects.equals(id, typeRoom.id) &&
                Objects.equals(hotelId, typeRoom.hotelId) &&
                Objects.equals(countOfMainBed, typeRoom.countOfMainBed) &&
                Objects.equals(typeOfMainBed, typeRoom.typeOfMainBed) &&
                Objects.equals(countOfChildBed, typeRoom.countOfChildBed) &&
                Objects.equals(priceForOneChildBed, typeRoom.priceForOneChildBed) &&
                Objects.equals(priceForDay, typeRoom.priceForDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelId, countOfMainBed, typeOfMainBed, countOfChildBed, priceForOneChildBed, priceForDay);
    }

    @Override
    public String toString() {
        return "TypeRoom{" +
                "id='" + id + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", countOfMainBed=" + countOfMainBed +
                ", typeOfMainBed=" + typeOfMainBed +
                ", countOfChildBed=" + countOfChildBed +
                ", priceForOneChildBed=" + priceForOneChildBed +
                ", priceForDay=" + priceForDay +
                '}';
    }
}



