package kr.swdl.foodingredientmanagement.service;

import kr.swdl.foodingredientmanagement.repository.IngredientRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class IngredientService {

    // repository 연결
    private final IngredientRepository ingredientRepository;

    // 생성자를 통해 Repository 주입
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    // 1. 식재료 목록 전체 조회
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getIngredientList(){

        // repository 호출후 결과 반환
        return ingredientRepository.findIngredientList();
    }

    // 2. 식재료 목록 소분류별 조회
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findSubCategoryList(
            @Param("subCategoryName") String subCategoryName
    );

    // 3. 식재료 목록 보관유형별 조회
    List<Map<String,Object>> findStorageTypeList(
            @Param("storageType") String storageType
    );

    // 4. 식재료 선택 삭제 (단일, 다중)
    boolean deleteIngredients(
            @Param("ids") List<Long> ids
    );

    // 5. 식재료 정보 등록
    boolean insertIngredient(
            Map<String, Object> ingredient
    );

    // 6. 식재료 상세 정보
    Map<String, Object> ingredientDetail(
            @Param("ingredientId") Long ingredientId
    );

    // 7. 식재료 상세 수정
    boolean ingredientUpdate(
            Map<String, Object> ingredient
    );
}
