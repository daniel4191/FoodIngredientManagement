package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private String ingredientName;
    private Integer orderQuantity;
    private String orderUnit;
    private Integer supplyPrice;
    private Integer orderPrice;
    private String orderStatus;
    private String rejectReason;
}
