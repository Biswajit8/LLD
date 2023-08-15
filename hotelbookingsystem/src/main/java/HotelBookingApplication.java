import exception.RoomNotAvailableException;
import models.*;

import java.util.Arrays;
import java.util.List;

public class HotelBookingApplication {
    public static void main(String[] args) throws RoomNotAvailableException {
        Customer customer1 = Customer.builder()
                .customerID(1)
                .customerName("Tony")
                .mobNo("9876543210")
                .email("tony@gmail.com")
                .build();

        Address address1 = Address.builder()
                .city("Kolkata")
                .pincode("789456")
                .build();

        Room room1 = Room.builder()
                .roomID(101)
                .hotelID(22)
                .roomType(RoomType.SINGLE)
                .roomStatus(RoomStatus.OCCUPIED)
                .build();

        Room room2 = Room.builder()
                .roomID(102)
                .hotelID(22)
                .roomType(RoomType.SINGLE)
                .roomStatus(RoomStatus.AVAILABLE)
                .build();

        List<Room> rooms = Arrays.asList(room1, room2);

        Hotel hotel1 = Hotel.builder()
                .hotelID(22)
                .hotelName("RoyalBengal")
                .address(address1)
                .rooms(rooms)
                .build();

        Booking booking = Booking.builder()
                .customer(customer1)
                .hotel(hotel1)
                .rooms(rooms)
                .paymentMode(PaymentMode.CASH)
                .duration(4)
                .build();

        Booking bookingResponse = booking.confirmBooking(customer1, hotel1, PaymentMode.CASH, 4, RoomType.DOUBLE);

        System.out.println(bookingResponse);
    }
}
