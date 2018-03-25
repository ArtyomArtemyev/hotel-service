package by.bsuir.artemyev.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HotelDto implements Serializable, Cloneable {
    private String id;
    private String name;
    private String city;
    private String address;
    private Integer countOfStars;
    private String description;
    private String photoName;
    private List<TypeRoomDto> rooms;

    public HotelDto() {
        super();
    }

    public HotelDto(String id, String name, String city, String address, Integer countOfStars, String description, String photoName, List<TypeRoomDto> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.countOfStars = countOfStars;
        this.description = description;
        this.photoName = photoName;
        this.rooms = rooms;
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

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public List<TypeRoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<TypeRoomDto> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDto hotelDto = (HotelDto) o;
        return Objects.equals(id, hotelDto.id) &&
                Objects.equals(name, hotelDto.name) &&
                Objects.equals(city, hotelDto.city) &&
                Objects.equals(address, hotelDto.address) &&
                Objects.equals(countOfStars, hotelDto.countOfStars) &&
                Objects.equals(description, hotelDto.description) &&
                Objects.equals(photoName, hotelDto.photoName) &&
                Objects.equals(rooms, hotelDto.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, address, countOfStars, description, photoName, rooms);
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", countOfStars=" + countOfStars +
                ", description='" + description + '\'' +
                ", photoName='" + photoName + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
