package kr.swdl.foodingredientmanagement.controller.responseDTO;


import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryUsageListResponse {

    private Timestamp consumptionAt;
    private Timestamp managementStartAt;
    private int usageQuantity;
    private String orderUnit;



}
