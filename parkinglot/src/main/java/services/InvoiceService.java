package services;

import models.*;
import repositories.InvoiceRepository;

import java.util.Date;

public class InvoiceService {

    private InvoiceRepository invoiceRepository = new InvoiceRepository();

    public Invoice generateInvoice(Payment payment, Gate gate) {
        Invoice invoice = Invoice.builder()
                .invoiceId((int) (Math.random()*100))
                .exitTime(new Date())
                .payment(payment)
                .exitGate(gate)
                .parkingAttendant(gate.getParkingAttendant())
                .build();
        invoiceRepository.save(invoice);

        return invoice;
    }
}
