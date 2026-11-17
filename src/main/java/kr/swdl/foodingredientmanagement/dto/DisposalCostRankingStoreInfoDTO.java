package kr.swdl.foodingredientmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisposalCostRankingStoreInfoDTO {
    private Long storeId;
    private String storeName;
    private int totalDisposalPrice;
    private int totalDisposalQuantity;
}
