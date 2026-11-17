package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class IngredientSaveDTO {

    major_category_name;
    supply_quantity;
    management_method;
    expiration_period;
    consumption_period;
    summer_consumption_period;

}
