package kr.swdl.foodingredientmanagement.controller.responseDTO;

import lombok.*;

import java.math.BigDecimal;

/**
 * Please explain the class!!
 *
 * @author : jungdayoung
 * @fileName : StoreInventoryListResponse
 * @since : 2026. 11. 17.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreInventoryListResponse {
    private String storeName; //
    private String subCategoryName;
    private String ingredientName;
    private String storageType;
    private int currentQuantity;
    private String orderUnit;
    private String userName;
}
