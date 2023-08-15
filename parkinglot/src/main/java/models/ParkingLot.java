package models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private String name;
    private String address;
}
