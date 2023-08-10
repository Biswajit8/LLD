package services;

import models.*;

public class ExitGateService {

    private InvoiceService invoiceService = new InvoiceService();

    public Invoice generateInvoice(Payment payment, Gate gate) {
        Invoice invoice = invoiceService.generateInvoice(payment,gate);
        return invoice;
    }
}
