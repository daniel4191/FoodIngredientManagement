package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.controller.responseDTO.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MBInventoryRepository {
//    전체 재고 목록 조회
  List<InventoryListResponse> findInventoryList();
//    조건 재고 목록 조회
 List<InventoryListResponse> findInventoryList(@Param("ingredientId") Long ingredientId,
                                               @Param("storeId") Long storeId,
                                               @Param("storeStartDate") LocalDate storeStartDate,
                                               @Param("storeEndDate") LocalDate storeEndDate,
                                               @Param("manageStartDate") LocalDate manageStartDate,
                                               @Param("manageEndDate") LocalDate manageEndDate);

     // 특정 직영점의 특정 재고 상세 조회
    // 잔여수량
    InventoryListResponse findInventoryCurrentQuantity(@Param("storeId") Long storeId,
                                                       @Param("ingredientId") Long ingredientId);

    // 식재료 정보
    InventoryIngredientResponse findInventoryIngredient(@Param("storeId") Long storeId,
                                                        @Param("ingredientId") Long ingredientId);

    // 입고 정보
    InventoryOrderResponse findInventoryOrder(@Param("storeId") Long storeId,
                                                  @Param("ingredientId") Long ingredientId);


    // 사용이력
    List <InventoryUsageListResponse> findInventoryUsageList(@Param("storeId") Long storeId,
                                                             @Param("ingredientId") Long ingredientId);


    // 직영점 전체 재고 목록 조회
    List<StoreInventoryListResponse> findStoreInventoryList(@Param("storeId") Long storeId,
                                                            @Param("subCategoryName") String subCategoryName,
                                                            @Param("ingredientId") Long ingredientId);
}



