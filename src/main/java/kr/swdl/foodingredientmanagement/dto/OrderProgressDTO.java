package kr.swdl.foodingredientmanagement.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProgressDTO {
    private Long orderId;
    private Timestamp orderAt;
    private Integer totalPrice;
    private String orderStatus;
    private Timestamp appAt;
    private Timestamp storeAt;
}

