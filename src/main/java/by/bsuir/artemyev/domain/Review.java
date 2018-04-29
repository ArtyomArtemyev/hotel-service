package by.bsuir.artemyev.domain;

import by.bsuir.artemyev.configuration.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "user_review")
public class Review implements Serializable, Cloneable {
    @Id
    private String id;
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date date;
    private String comment;
    private InternalUserDto userDto;
    private Hotel hotel;

    public Review() {
        super();
    }

    public Review(String id, Date date, String comment, InternalUserDto userDto, Hotel hotel) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.userDto = userDto;
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public InternalUserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(InternalUserDto userDto) {
        this.userDto = userDto;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) &&
                Objects.equals(date, review.date) &&
                Objects.equals(comment, review.comment) &&
                Objects.equals(userDto, review.userDto) &&
                Objects.equals(hotel, review.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, comment, userDto, hotel);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", userDto=" + userDto +
                ", hotel=" + hotel +
                '}';
    }
}
