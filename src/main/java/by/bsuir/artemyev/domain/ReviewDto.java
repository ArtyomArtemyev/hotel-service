package by.bsuir.artemyev.domain;

import java.util.List;
import java.util.Objects;

public class ReviewDto {
    private Hotel hotel;
    private List<Review> reviews;

    public ReviewDto() {
        super();
    }

    public ReviewDto(Hotel hotel, List<Review> reviews) {
        this.hotel = hotel;
        this.reviews = reviews;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return Objects.equals(hotel, reviewDto.hotel) &&
                Objects.equals(reviews, reviewDto.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, reviews);
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "hotel=" + hotel +
                ", reviews=" + reviews +
                '}';
    }
}
