package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class IngredientDTO {
    private String ingredientName;
    private String subCategoryName;
    private int capacity;
    private String capacityUnit;
    private String orderUnit ;
    private String storageType;
    private int supplyPrice;


    private int supplyQuantity;


}
