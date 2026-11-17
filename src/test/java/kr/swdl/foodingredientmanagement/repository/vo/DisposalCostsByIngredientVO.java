package kr.swdl.foodingredientmanagement.repository.vo;

import lombok.Data;

@Data
public class DisposalCostsByIngredientVO {
    private String ingredientId;
    private String ingredientName;
    private int totalDisposalPrice;
    private int totalDisposalQuantity;
}
