package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class StoreOrderDisposalRateDTO {
    private Long storeId;
    private String storeName;
    private int totalOrderCount;
    private int totalDisposalCount;
    private double disposalRatePct;

}
