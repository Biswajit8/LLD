package dto;

import lombok.Builder;
import lombok.Data;
import models.Gate;
import models.Vehicle;

@Data
@Builder
public class GenerateTicketRequest {
    private Vehicle vehicle;
    private Gate gate;
}
