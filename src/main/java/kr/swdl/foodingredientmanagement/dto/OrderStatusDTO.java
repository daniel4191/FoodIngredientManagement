package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

@Data
public class OrderStatusDTO {
    private Long orderId;
    private String orderStatus;
}
