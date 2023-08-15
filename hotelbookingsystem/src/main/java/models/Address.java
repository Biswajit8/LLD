package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String city;
    private String pincode;
}
