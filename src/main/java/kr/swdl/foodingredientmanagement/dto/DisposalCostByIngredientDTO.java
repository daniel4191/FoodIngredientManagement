package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class DisposalCostByIngredientDTO {
    private Long ingredientId;
    private String ingredientName;
    private int totalDisposalPrice;
    private int totalDisposalQuantity;
}
