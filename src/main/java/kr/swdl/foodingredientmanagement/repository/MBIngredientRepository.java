package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.IngredientDetailDTO;
import kr.swdl.foodingredientmanagement.dto.IngredientInsertDTO;
import kr.swdl.foodingredientmanagement.dto.IngredientListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MBIngredientRepository {
    // 1. 식재료 목록 조회 (본사)
    //      목록 전체 조회 !!
    List<IngredientListDTO> findIngredientList();

    //      분류로 목록 조회 !!
    //      보관유형 목록 조회 !!
    //      식재료명 목록 조회 !!
    //      식재료명 + 분류 목록 조회 !!
    //      식재료명 + 보관유형 목록 조회 !!
    List<IngredientListDTO> findIngredientList(
                        @Param("storageType") String storageType,
                        @Param("subCategoryName") String subCategoryName,
                        @Param("ingredientName") String ingredientName
    );

    // 2. 식재료 상세 조회 (본사)
    IngredientDetailDTO  findIngredientDetail(@Param("ingredientId")Long ingredientId);



    // 3. 식재료 정보 등록
    int addIngredientDetail(IngredientInsertDTO ingredientInsertDTO);

}
