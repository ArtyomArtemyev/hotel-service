package by.bsuir.artemyev.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "services_prices")
public class ServicePrice implements Serializable, Cloneable {

    @JsonProperty("id")
    @Id
    private String id;

    @JsonProperty("service")
    private String service;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("isRoom")
    private Boolean isRoom;

    public ServicePrice() {
        super();
    }

    public ServicePrice(String id, String service, Float price, Boolean isRoom) {
        this.id = id;
        this.service = service;
        this.price = price;
        this.isRoom = isRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getRoom() {
        return isRoom;
    }

    public void setRoom(Boolean room) {
        isRoom = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePrice that = (ServicePrice) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(service, that.service) &&
                Objects.equals(price, that.price) &&
                Objects.equals(isRoom, that.isRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, service, price, isRoom);
    }

    @Override
    public String toString() {
        return "ServicePrice{" +
                "id='" + id + '\'' +
                ", service='" + service + '\'' +
                ", price=" + price +
                ", isRoom=" + isRoom +
                '}';
    }
}
