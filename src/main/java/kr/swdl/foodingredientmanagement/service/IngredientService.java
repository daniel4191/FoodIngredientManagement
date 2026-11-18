package kr.swdl.foodingredientmanagement.service;

import jakarta.transaction.Transactional;
import kr.swdl.foodingredientmanagement.dto.IngredientDetailDTO;
import kr.swdl.foodingredientmanagement.repository.IngredientRepository;
import kr.swdl.foodingredientmanagement.repository.entitiy.Ingredients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public Long addIngredientDetail(Ingredients ingredients, List<IngredientDetailDTO> list){
        Long ingredientId = null;
        return ingredientId;
    }
}
