package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class DisposalCostRankingStoreInfoDTO {
    private Long storeId;
    private String storeName;
    private int totalDisposalPrice;
    private int totalDisposalQuantity;
}
