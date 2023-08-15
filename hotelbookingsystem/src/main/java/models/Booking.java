package models;

import exception.RoomNotAvailableException;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Booking {
    private int bookingID;
    private Customer customer;
    private Hotel hotel;
    private List<Room> rooms;
    private PaymentMode paymentMode;
    private int duration;

    public Booking confirmBooking(Customer customer, Hotel hotel, PaymentMode paymentMode, int duration, RoomType roomType) throws RoomNotAvailableException {
        Room room = this.hotel.checkAvailability(rooms, roomType);
        if(room != null) {
            return Booking.builder()
                    .bookingID((int) (Math.random()*100))
                    .customer(customer)
                    .hotel(hotel)
                    .paymentMode(paymentMode)
                    .duration(duration)
                    .build();
        }
        else {
            throw new RoomNotAvailableException();
        }
    }
}
