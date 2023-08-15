package dto;

import lombok.Builder;
import lombok.Data;
import models.Ticket;

@Data
@Builder
public class GenerateTicketResponse {
    private Ticket ticket;
}
