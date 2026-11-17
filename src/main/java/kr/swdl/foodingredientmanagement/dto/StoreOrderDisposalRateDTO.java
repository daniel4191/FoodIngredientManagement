package kr.swdl.foodingredientmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreOrderDisposalRateDTO {
    private Long storeId;
    private String storeName;
    private int totalOrderCount;
    private int totalDisposalCount;
    private double disposalRatePct;

}
