package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDetailRequestDTO {
    private Long orderDetailId;

    private Long ingredientId;

    private Integer orderQuantity;

    private Integer supplyPrice;

    private Integer orderPrice;

    private Timestamp manufactureAt;

    private Timestamp storeAt;

    private Timestamp appAt;

    private String orderStatus;

    private String rejectReason;

    private Integer currentQuantity;

    private Long orderId;
}
