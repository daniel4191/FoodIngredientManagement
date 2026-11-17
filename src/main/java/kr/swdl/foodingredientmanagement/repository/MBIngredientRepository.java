package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.IngredientDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MBIngredientRepository {
    // 1. 식재료 목록 조회 (본사)

    //      분류로 목록 조회 !!
    //      보관유형 목록 조회 !!
    //      식재료명 목록 조회 !!
    //      식재료명 + 분류 목록 조회 !!
    //      식재료명 + 보관유형 목록 조회 !!



    //      목록 전체 조회 !!
    List<IngredientDTO> findIngredientList();


}
