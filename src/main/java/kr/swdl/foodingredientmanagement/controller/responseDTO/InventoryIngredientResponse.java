package kr.swdl.foodingredientmanagement.controller.responseDTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryIngredientResponse {

    private String storeName;

    private String ingredientName;
    private String storageType;
    private String orderUnit;

    private String managementMethod;


    private int capacity;

    private String capacityUnit;
    private int expirationPeriod;
    private int consumptionPeriod;
    private int summerConsumptionPeriod;









}
