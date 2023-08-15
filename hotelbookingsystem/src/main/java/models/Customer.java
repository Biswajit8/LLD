package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private int customerID;
    private String customerName;
    private String mobNo;
    private String email;
}
