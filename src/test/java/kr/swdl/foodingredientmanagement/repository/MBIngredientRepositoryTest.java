package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.IngredientDetailDTO;
import kr.swdl.foodingredientmanagement.dto.IngredientInsertDTO;
import kr.swdl.foodingredientmanagement.dto.IngredientListDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class MBIngredientRepositoryTest {
    @Autowired
    private MBIngredientRepository mbIngredientRepository;

    @Test
    void 식재료_전체_목록_조회(){
        List<IngredientListDTO> list = mbIngredientRepository.findIngredientList();
        assertThat(list).isNotEmpty();

        for (IngredientListDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());
        }
    }

    @Test
    void 식재료_분류별_목록_조회(){
        List<IngredientListDTO> list = mbIngredientRepository.findIngredientList("냉장", null, null);
        assertThat(list).isNotEmpty();

        for (IngredientListDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());
        }
    }

    @Test
    void 식재료_보관유형별_목록_조회(){
        List<IngredientListDTO> list = mbIngredientRepository.findIngredientList(null, "채소류", null);
        assertThat(list).isNotEmpty();

        for (IngredientListDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());
        }

    }
    @Test
    void 식재료_식재료명_목록_조회(){
        List<IngredientListDTO> list = mbIngredientRepository.findIngredientList(null, null, "치");
        assertThat(list).isNotEmpty();

        for (IngredientListDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());
        }
    }

    @Test
    void 식재료_식재료명_분류_목록_조회(){
        List<IngredientListDTO> list = mbIngredientRepository.findIngredientList(null, "유제품류", "치");
        assertThat(list).isNotEmpty();

        for (IngredientListDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());
        }
    }

    @Test
    void 식재료_식재료명_보관유형_목록_조회(){
        List<IngredientListDTO> list = mbIngredientRepository.findIngredientList("냉장", null, "치");
        assertThat(list).isNotEmpty();

        for (IngredientListDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());
        }
    }

    @Test
    void 식재료_상세_조회(){
        IngredientDetailDTO ingredientDetailDTO = mbIngredientRepository.findIngredientDetail(1L);
        assertThat(ingredientDetailDTO).isNotNull();
        assertThat(ingredientDetailDTO.getIngredientId()).isEqualTo(1L);

        log.info("상세: {}", ingredientDetailDTO);
    }








    @Test
    @Transactional
    void 식재료_등록() {
        IngredientInsertDTO dto = IngredientInsertDTO.builder()
                .ingredientName("양상추")
                .majorCategoryName("채소류")
                .subCategoryName("잎채소")
                .storageType("냉장")
                .orderUnit("박스")
                .capacity(5000)
                .capacityUnit("g")
                .managementMethod("입고일")
                .consumptionPeriod(8)
                .summerConsumptionPeriod(8)
                .expirationPeriod(3)
                .supplyPrice(15000)
                .supplyQuantity(10)
                .build();

        int result = mbIngredientRepository.addIngredientDetail(dto);

        assertThat(result).isEqualTo(1);
        assertThat(dto.getIngredientId()).isNotNull();
        log.info("등록된 식재료 ID: {}", dto.getIngredientId());

        IngredientDetailDTO saved = mbIngredientRepository.findIngredientDetail(dto.getIngredientId());
        assertThat(saved).isNotNull();
        assertThat(saved.getIngredientName()).isEqualTo("양상추");
        assertThat(saved.getUsableFlag()).isEqualTo("Y");


    }
}
