package by.bsuir.artemyev.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document(collection = "hotels")
public class Hotel implements Serializable, Cloneable {

    @Id
    private String id;
    private String name;
    private String city;
    private String address;
    private Integer countOfStars;
    private String description;
    private List<String> photosIds;

    public Hotel() {
        super();
    }

    public Hotel(String id, String name, String city, String address, Integer countOfStars, String description, List<String> photosIds) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.countOfStars = countOfStars;
        this.description = description;
        this.photosIds = photosIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountOfStars() {
        return countOfStars;
    }

    public void setCountOfStars(Integer countOfStars) {
        this.countOfStars = countOfStars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotosIds() {
        return photosIds;
    }

    public void setPhotosIds(List<String> photosIds) {
        this.photosIds = photosIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) &&
                Objects.equals(name, hotel.name) &&
                Objects.equals(city, hotel.city) &&
                Objects.equals(address, hotel.address) &&
                Objects.equals(countOfStars, hotel.countOfStars) &&
                Objects.equals(description, hotel.description) &&
                Objects.equals(photosIds, hotel.photosIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, address, countOfStars, description, photosIds);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", countOfStars=" + countOfStars +
                ", description='" + description + '\'' +
                ", photosIds=" + photosIds +
                '}';
    }
}
