package kr.swdl.foodingredientmanagement.dto;

import lombok.Builder;

@Builder
public class StoreDisposalSerachFilterDTO {
    private String ingredientName;
    private String disposalStatus;
    private String processingMethod;
    private String startDate;
    private String endDate;
    private String sortType;
    private int pageCnt;
}
