package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDTO {
    private Long orderId;
    private Timestamp orderAt;
    private String storeName;
    private String firstIngredientName;
    private Long ingredientCount;
    private Integer totalPrice;
    private Timestamp storeAt;
}
