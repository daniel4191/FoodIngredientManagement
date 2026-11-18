package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class IngredientSaveDTO extends IngredientListDTO{

    private String major_category_name;
    private int supply_quantity;
    private String management_method;
    private int expiration_period;
    private int consumption_period;
    private int summer_consumption_period;

}
