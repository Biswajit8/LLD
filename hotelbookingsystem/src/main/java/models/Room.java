package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    private int roomID;
    private int hotelID;
    private RoomType roomType;
    private RoomStatus roomStatus;
}
