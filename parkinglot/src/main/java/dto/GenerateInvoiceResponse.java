package dto;

import lombok.Builder;
import lombok.Data;
import models.Invoice;

@Data
@Builder
public class GenerateInvoiceResponse {
    private Invoice invoice;
}
