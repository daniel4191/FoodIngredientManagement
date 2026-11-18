package kr.swdl.foodingredientmanagement.service;

import kr.swdl.foodingredientmanagement.repository.MBInventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private MBInventoryRepository mbInventoryRepository;

    @Test
    void 본사_전체_재고_목록_조회(){

    }

    @Test
    void 본사_목록_조회_실패(){

    }
}
