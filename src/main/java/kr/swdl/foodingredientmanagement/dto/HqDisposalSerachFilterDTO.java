package kr.swdl.foodingredientmanagement.dto;

import lombok.Builder;

@Builder
public class HqDisposalSerachFilterDTO {
    private String storeName;
    private String ingredientName;
    private String disposalStatus;
    private String startDate;
    private String endDate;
    private String disposalType;
    private String processingMethod;
    private String sortType;
}
