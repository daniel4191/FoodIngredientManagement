package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.IngredientDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class MBIngredientRepositoryTest {
    @Autowired
    private MBIngredientRepository mbIngredientRepository;

    @Test
    void 식재료_목록_전체_조회(){
        List<IngredientDTO> list = mbIngredientRepository.findIngredientList();
        assertThat(list).isNotEmpty();

        for (IngredientDTO ingredientDTO : list){
            log.info("식재료 명:  {}" , ingredientDTO.getIngredientName());
            log.info("분류 :  {}" , ingredientDTO.getSubCategoryName());
            log.info("용량 :  {}" , ingredientDTO.getCapacity());
            log.info("용량 단위 :  {}" , ingredientDTO.getCapacityUnit());
            log.info("보관 유형 :  {}" , ingredientDTO.getStorageType());
            log.info("단가:  {}" , ingredientDTO.getSupplyPrice());


        }

    }

}
