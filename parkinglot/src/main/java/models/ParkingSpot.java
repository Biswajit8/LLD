package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSpot {
    private int spotNumber;
    private VehicleType supportedVehicleType;
    private SpotStatus spotStatus;
    private int floorNumber;
    private Vehicle vehicle;
}
