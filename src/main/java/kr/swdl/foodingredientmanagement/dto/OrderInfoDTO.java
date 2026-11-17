package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderInfoDTO {
    private Long orderId;
    private Timestamp orderAt;
    private String storeName;
    private Timestamp appAt;
    private Timestamp storeAt;
    private Integer totalPrice;
    private String userName;
}
