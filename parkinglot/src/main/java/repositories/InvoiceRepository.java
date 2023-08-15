package repositories;

import models.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private List<Invoice> invoices = new ArrayList<>();

    public void save(Invoice invoice) {
        invoices.add(invoice);
    }
}
