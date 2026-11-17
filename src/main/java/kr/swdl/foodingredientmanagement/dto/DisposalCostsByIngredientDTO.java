package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class DisposalCostsByIngredientDTO {
    private String ingredientId;
    private String ingredientName;
    private int totalDisposalPrice;
    private int totalDisposalQuantity;
}
