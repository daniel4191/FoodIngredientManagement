package kr.swdl.foodingredientmanagement.service;

import kr.swdl.foodingredientmanagement.dto.InventoryListResponseDTO;
import kr.swdl.foodingredientmanagement.repository.MBInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final MBInventoryRepository mbInventoryRepository;

    public List<InventoryListResponseDTO> findInventoryList(){
        return mbInventoryRepository.findInventoryList(null, null, null, null, null, null);
    }

    public List<InventoryListResponseDTO> findInventoryList(Long ingredientId,
                                                            Long storeId,
                                                            LocalDate storeStartDate,
                                                            LocalDate storeEndDate,
                                                            LocalDate manageStartDate,
                                                            LocalDate manageEndDate){
        return mbInventoryRepository.findInventoryList( ingredientId, storeId, storeStartDate, storeEndDate,  manageStartDate, manageEndDate );
    }



}
