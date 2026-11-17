package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class IngredientDisposalRateToOrderByStoreDTO {

    private Long storeId;
    private String storeName;
    private Long ingredientId;
    private String ingredientName;
    private int totalOrderCount;
    private int totalDisposalCount;
    private double disposalRatePct;
}
