package kr.swdl.foodingredientmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DisposalCostByIngredientDTO {
    private Long ingredientId;
    private String ingredientName;
    private int totalDisposalPrice;
    private int totalDisposalQuantity;
}
