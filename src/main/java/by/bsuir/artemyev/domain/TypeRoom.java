package by.bsuir.artemyev.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "type_rooms")
public class TypeRoom implements Serializable, Cloneable {

    @Id
    private String id;
    private String typeRoomName;
    private String typeRoomWorldName;
    private Boolean isExistLivingRoom;
    private Boolean isExistSleepingRoom;
    private Boolean isExistCabinet;
    private Boolean isExistMeetingRoom;
    private Boolean isExistShowingRoom;
    private Boolean isExistBathRoom;
    private Boolean isExistTV;
    private Boolean isExistBar;
    private Boolean isExistWiFi;
    private Boolean isExistBalcony;
    private Boolean isExistKitchen;
    private Boolean isExistDiningRoom;
    private Boolean isExistWCRoom;
    private Boolean isExistAdditionalWCRoom;
    private Integer countOfMan;
    private String typeOfMainBed;
    private Boolean isExistChildBed;

    public TypeRoom() {
        super();
    }

    public TypeRoom(String id, String typeRoomName, String typeRoomWorldName, Boolean isExistLivingRoom, Boolean isExistSleepingRoom, Boolean isExistCabinet, Boolean isExistMeetingRoom, Boolean isExistShowingRoom, Boolean isExistBathRoom, Boolean isExistTV, Boolean isExistBar, Boolean isExistWiFi, Boolean isExistBalcony, Boolean isExistKitchen, Boolean isExistDiningRoom, Boolean isExistWCRoom, Boolean isExistAdditionalWCRoom, Integer countOfMan, String typeOfMainBed, Boolean isExistChildBed) {
        this.id = id;
        this.typeRoomName = typeRoomName;
        this.typeRoomWorldName = typeRoomWorldName;
        this.isExistLivingRoom = isExistLivingRoom;
        this.isExistSleepingRoom = isExistSleepingRoom;
        this.isExistCabinet = isExistCabinet;
        this.isExistMeetingRoom = isExistMeetingRoom;
        this.isExistShowingRoom = isExistShowingRoom;
        this.isExistBathRoom = isExistBathRoom;
        this.isExistTV = isExistTV;
        this.isExistBar = isExistBar;
        this.isExistWiFi = isExistWiFi;
        this.isExistBalcony = isExistBalcony;
        this.isExistKitchen = isExistKitchen;
        this.isExistDiningRoom = isExistDiningRoom;
        this.isExistWCRoom = isExistWCRoom;
        this.isExistAdditionalWCRoom = isExistAdditionalWCRoom;
        this.countOfMan = countOfMan;
        this.typeOfMainBed = typeOfMainBed;
        this.isExistChildBed = isExistChildBed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeRoomName() {
        return typeRoomName;
    }

    public void setTypeRoomName(String typeRoomName) {
        this.typeRoomName = typeRoomName;
    }

    public String getTypeRoomWorldName() {
        return typeRoomWorldName;
    }

    public void setTypeRoomWorldName(String typeRoomWorldName) {
        this.typeRoomWorldName = typeRoomWorldName;
    }

    public Boolean getExistLivingRoom() {
        return isExistLivingRoom;
    }

    public void setExistLivingRoom(Boolean existLivingRoom) {
        isExistLivingRoom = existLivingRoom;
    }

    public Boolean getExistSleepingRoom() {
        return isExistSleepingRoom;
    }

    public void setExistSleepingRoom(Boolean existSleepingRoom) {
        isExistSleepingRoom = existSleepingRoom;
    }

    public Boolean getExistCabinet() {
        return isExistCabinet;
    }

    public void setExistCabinet(Boolean existCabinet) {
        isExistCabinet = existCabinet;
    }

    public Boolean getExistMeetingRoom() {
        return isExistMeetingRoom;
    }

    public void setExistMeetingRoom(Boolean existMeetingRoom) {
        isExistMeetingRoom = existMeetingRoom;
    }

    public Boolean getExistShowingRoom() {
        return isExistShowingRoom;
    }

    public void setExistShowingRoom(Boolean existShowingRoom) {
        isExistShowingRoom = existShowingRoom;
    }

    public Boolean getExistBathRoom() {
        return isExistBathRoom;
    }

    public void setExistBathRoom(Boolean existBathRoom) {
        isExistBathRoom = existBathRoom;
    }

    public Boolean getExistTV() {
        return isExistTV;
    }

    public void setExistTV(Boolean existTV) {
        isExistTV = existTV;
    }

    public Boolean getExistBar() {
        return isExistBar;
    }

    public void setExistBar(Boolean existBar) {
        isExistBar = existBar;
    }

    public Boolean getExistWiFi() {
        return isExistWiFi;
    }

    public void setExistWiFi(Boolean existWiFi) {
        isExistWiFi = existWiFi;
    }

    public Boolean getExistBalcony() {
        return isExistBalcony;
    }

    public void setExistBalcony(Boolean existBalcony) {
        isExistBalcony = existBalcony;
    }

    public Boolean getExistKitchen() {
        return isExistKitchen;
    }

    public void setExistKitchen(Boolean existKitchen) {
        isExistKitchen = existKitchen;
    }

    public Boolean getExistDiningRoom() {
        return isExistDiningRoom;
    }

    public void setExistDiningRoom(Boolean existDiningRoom) {
        isExistDiningRoom = existDiningRoom;
    }

    public Boolean getExistWCRoom() {
        return isExistWCRoom;
    }

    public void setExistWCRoom(Boolean existWCRoom) {
        isExistWCRoom = existWCRoom;
    }

    public Boolean getExistAdditionalWCRoom() {
        return isExistAdditionalWCRoom;
    }

    public void setExistAdditionalWCRoom(Boolean existAdditionalWCRoom) {
        isExistAdditionalWCRoom = existAdditionalWCRoom;
    }

    public Integer getCountOfMan() {
        return countOfMan;
    }

    public void setCountOfMan(Integer countOfMan) {
        this.countOfMan = countOfMan;
    }

    public String getTypeOfMainBed() {
        return typeOfMainBed;
    }

    public void setTypeOfMainBed(String typeOfMainBed) {
        this.typeOfMainBed = typeOfMainBed;
    }

    public Boolean getExistChildBed() {
        return isExistChildBed;
    }

    public void setExistChildBed(Boolean existChildBed) {
        isExistChildBed = existChildBed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeRoom typeRoom = (TypeRoom) o;
        return Objects.equals(id, typeRoom.id) &&
                Objects.equals(typeRoomName, typeRoom.typeRoomName) &&
                Objects.equals(typeRoomWorldName, typeRoom.typeRoomWorldName) &&
                Objects.equals(isExistLivingRoom, typeRoom.isExistLivingRoom) &&
                Objects.equals(isExistSleepingRoom, typeRoom.isExistSleepingRoom) &&
                Objects.equals(isExistCabinet, typeRoom.isExistCabinet) &&
                Objects.equals(isExistMeetingRoom, typeRoom.isExistMeetingRoom) &&
                Objects.equals(isExistShowingRoom, typeRoom.isExistShowingRoom) &&
                Objects.equals(isExistBathRoom, typeRoom.isExistBathRoom) &&
                Objects.equals(isExistTV, typeRoom.isExistTV) &&
                Objects.equals(isExistBar, typeRoom.isExistBar) &&
                Objects.equals(isExistWiFi, typeRoom.isExistWiFi) &&
                Objects.equals(isExistBalcony, typeRoom.isExistBalcony) &&
                Objects.equals(isExistKitchen, typeRoom.isExistKitchen) &&
                Objects.equals(isExistDiningRoom, typeRoom.isExistDiningRoom) &&
                Objects.equals(isExistWCRoom, typeRoom.isExistWCRoom) &&
                Objects.equals(isExistAdditionalWCRoom, typeRoom.isExistAdditionalWCRoom) &&
                Objects.equals(countOfMan, typeRoom.countOfMan) &&
                Objects.equals(typeOfMainBed, typeRoom.typeOfMainBed) &&
                Objects.equals(isExistChildBed, typeRoom.isExistChildBed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeRoomName, typeRoomWorldName, isExistLivingRoom, isExistSleepingRoom, isExistCabinet, isExistMeetingRoom, isExistShowingRoom, isExistBathRoom, isExistTV, isExistBar, isExistWiFi, isExistBalcony, isExistKitchen, isExistDiningRoom, isExistWCRoom, isExistAdditionalWCRoom, countOfMan, typeOfMainBed, isExistChildBed);
    }

    @Override
    public String toString() {
        return "TypeRoom{" +
                "id='" + id + '\'' +
                ", typeRoomName='" + typeRoomName + '\'' +
                ", typeRoomWorldName='" + typeRoomWorldName + '\'' +
                ", isExistLivingRoom=" + isExistLivingRoom +
                ", isExistSleepingRoom=" + isExistSleepingRoom +
                ", isExistCabinet=" + isExistCabinet +
                ", isExistMeetingRoom=" + isExistMeetingRoom +
                ", isExistShowingRoom=" + isExistShowingRoom +
                ", isExistBathRoom=" + isExistBathRoom +
                ", isExistTV=" + isExistTV +
                ", isExistBar=" + isExistBar +
                ", isExistWiFi=" + isExistWiFi +
                ", isExistBalcony=" + isExistBalcony +
                ", isExistKitchen=" + isExistKitchen +
                ", isExistDiningRoom=" + isExistDiningRoom +
                ", isExistWCRoom=" + isExistWCRoom +
                ", isExistAdditionalWCRoom=" + isExistAdditionalWCRoom +
                ", countOfMan=" + countOfMan +
                ", typeOfMainBed='" + typeOfMainBed + '\'' +
                ", isExistChildBed=" + isExistChildBed +
                '}';
    }
}



