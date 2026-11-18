package kr.swdl.foodingredientmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.swdl.foodingredientmanagement.repository.entitiy.Ingredients;

import java.util.List;

public interface JPAIngredientRepository extends JpaRepository<Ingredients, Long> {
    // 1. 식재료 목록 전체 조회 - JpaRepository의 findAll()

    // 2. 식재료 목록 소분류별 조회
    List<Ingredients> getBySubCategoryName(String subCategoryName);

    // 3. 식재료 목록 보관유형별 조회
    List<Ingredients> getByStorageType(String storageType);

    // 4. 식재료 선택 삭제 (단일, 다중) - Jpa deleteAllById()

    // 5. 식재료 정보 등록 - Jpa save()

    // 6. 식재료 상세 정보 - jpa findById()

    // 7. 식재료 상세 수정 - jpa findById()후에 service에서 값변경

}
