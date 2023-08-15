package models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Invoice {

    private int invoiceId;
    private Date exitTime;
    private Ticket ticket;
    private Payment payment;
    private Gate exitGate;
    private ParkingAttendant parkingAttendant;
}
