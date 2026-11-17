package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class IngredientDTO {
    private String ingredientName;
    private Integer supplyPrice;
    private Integer supplyQuantity;
}
