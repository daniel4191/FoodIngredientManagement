package kr.swdl.foodingredientmanagement.controller.responseDTO;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryOrderResponse {


    private Timestamp manufactureAt;
    private Timestamp expirationDate;
    private Timestamp storeAt;
    private int orderQuantity;
    private String orderUnit;

}
