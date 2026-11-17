package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class IngredientListDTO {
    private String ingredient_id;
    private String ingredient_name;
    private String sub_category_name;
    private int capacity;
    private String capacity_unit;
    private String order_unit;
    private String storage_type;
    private int supply_price;
}


