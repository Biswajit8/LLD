package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Hotel {
    private int hotelID;
    private String hotelName;
    private Address address;
    private List<Room> rooms;

    public Room checkAvailability(List<Room> rooms, RoomType roomType) {
        for(Room room : rooms) {
            if(room.getRoomStatus() == RoomStatus.AVAILABLE && room.getRoomType() == roomType) {
                return room;
            }
        }
        return null;
    }
}
