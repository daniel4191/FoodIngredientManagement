package kr.swdl.foodingredientmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderStatusCountDTO {
    private int waitingCount;
    private int approvedCount;
    private int rejectedCount;
}
