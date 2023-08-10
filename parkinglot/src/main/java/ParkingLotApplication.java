import controllers.TicketController;
import dto.GenerateInvoiceResponse;
import dto.GenerateTicketRequest;
import dto.GenerateTicketResponse;
import exceptions.NoParkingSpotsAvailableException;
import models.*;
import services.EntryGateService;
import services.ExitGateService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ParkingLotApplication {
    public static void main(String[] args) {
        Vehicle car = Vehicle.builder().vehicleType(VehicleType.CAR).regNumber("1224").build();
        Vehicle suv = Vehicle.builder().vehicleType(VehicleType.SUV).regNumber("7890").build();

        ParkingAttendant pa = ParkingAttendant.builder().email("abc@Gmail.com").name("abc").build();
        ParkingAttendant pa2 = ParkingAttendant.builder().email("tony@Gmail.com").name("tony").build();

        Gate entryGate = Gate.builder()
                .gateNumber(1)
                .parkingAttendant(pa)
                .build();

        Gate exitGate = Gate.builder()
                .gateNumber(3)
                .parkingAttendant(pa2)
                .build();

        ParkingLot parkingLot = ParkingLot.builder()
                .entryGates(Arrays.asList(entryGate))
                .address("Some random address")
                .name("Random name")
                .build();

        EntryGateService entryGateService = new EntryGateService();
        ExitGateService exitGateService = new ExitGateService();

        TicketController controller = new TicketController(entryGateService,exitGateService);

        try {
            GenerateTicketResponse response = controller.generateTicket(
                    GenerateTicketRequest.builder().vehicle(car).gate(entryGate).build());
//            GenerateTicketResponse response = controller.generateTicket(
//                    GenerateTicketRequest.builder().vehicle(suv).gate(entryGate).build()); // NoParkingSpotsAvailableException
            System.out.println(response.getTicket());
            Payment payment1 = Payment.builder()
                    .reference("xyz")
                    .amount(250.00)
                    .paymentMode(PaymentMode.CASH)
                    .paymentStatus(PaymentStatus.SUCCESS)
                    .time(new Date())
                    .ticket(response.getTicket())
                    .build();
            GenerateInvoiceResponse invoiceResponse = controller.generateInvoice(payment1,exitGate);
            System.out.println(invoiceResponse.getInvoice());
        } catch (NoParkingSpotsAvailableException e) {
            throw new RuntimeException(e);
        }

    }
}
