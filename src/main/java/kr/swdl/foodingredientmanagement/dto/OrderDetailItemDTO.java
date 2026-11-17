package kr.swdl.foodingredientmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailItemDTO {
    private String ingredientName;
    private Integer orderQuantity;
    private String orderUnit;
    private Integer supplyPrice;
    private Integer orderPrice;
    private String userName;
}
