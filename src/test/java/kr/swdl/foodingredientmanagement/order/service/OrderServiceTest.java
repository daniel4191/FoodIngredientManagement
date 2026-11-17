package kr.swdl.foodingredientmanagement.order.service;

import kr.swdl.foodingredientmanagement.dto.*;
import kr.swdl.foodingredientmanagement.repository.JPAOrderRepository;
import kr.swdl.foodingredientmanagement.repository.MBOrderRepository;
import kr.swdl.foodingredientmanagement.repository.entitiy.Orders;
import kr.swdl.foodingredientmanagement.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private JPAOrderRepository jpaOrderRepository;

    @Autowired
    private MBOrderRepository mbOrderRepository;

    // 1. 발주 등록
    @Test
    void 발주_상세_품목_등록_테스트() {

        Orders order = Orders.builder()
                .orderAt(Timestamp.valueOf(LocalDateTime.now()))
                .appAt(Timestamp.valueOf(LocalDateTime.now()))
                .totalPrice(0)
                .userId(1)
                .storeId(1)
                .build();

        List<OrderDetailRequestDTO> detailList = new ArrayList<>();

        OrderDetailRequestDTO detail1 = new OrderDetailRequestDTO();
        detail1.setIngredientId(1L);
        detail1.setOrderQuantity(10);
        detail1.setSupplyPrice(2000);
        detail1.setOrderPrice(20000);

        OrderDetailRequestDTO detail2 = new OrderDetailRequestDTO();
        detail2.setIngredientId(2L);
        detail2.setOrderQuantity(5);
        detail2.setSupplyPrice(3000);
        detail2.setOrderPrice(15000);

        detailList.add(detail1);
        detailList.add(detail2);


        Long orderId = orderService.registerOrder(order, detailList);

        int count = mbOrderRepository.countOrderDetails(orderId);
        Long totalPrice = mbOrderRepository.selectOrderTotalPrice(orderId);

        assertNotNull(orderId);
        assertEquals(2, count);
        assertEquals(35000L, totalPrice);

        log.info("발주 번호: {}", orderId);
        log.info("상세 품목 수: {}", count);
        log.info("발주 총금액: {}", totalPrice);


    }

    //2. 발주 조회
    @Test
    void 직영점_발주_요청_조회() {
        List<OrderListDTO> result =
                mbOrderRepository.findOrderDetail(
                        4L,
                        "2026-11-01 00:00:00",
                        "2026-11-11 00:00:00",
                        "ORDER"
                );

        log.info("조회 결과: {}", result);

        assertNotNull(result);

        for (OrderListDTO dto : result) {
            assertNotNull(dto.getOrderId());
            assertNotNull(dto.getOrderAt());

            log.info("발주번호: {}", dto.getOrderId());
            log.info("발주일: {}", dto.getOrderAt());
            log.info("식재료: {}", dto.getIngredientName());
            log.info("식재료 종류 수: {}", dto.getIngredientCount());
            log.info("총 가격: {}", dto.getTotalPrice());
            log.info("발주 상태: {}", dto.getOrderStatus());
            log.info("입고일: {}", dto.getStoreAt());
        }
    }

    @Test
    void 매장별_발주_정보_조회() {
        Long storeId = 2L;

        List<OrderProgressDTO> result =
                mbOrderRepository.findOrderProgress(storeId);

        assertNotNull(result);

        for (OrderProgressDTO dto : result) {

            assertNotNull(dto.getOrderId());
            assertNotNull(dto.getOrderAt());
            assertNotNull(dto.getTotalPrice());
            assertNotNull(dto.getOrderStatus());

            log.info("발주번호: {}", dto.getOrderId());
            log.info("발주일: {}", dto.getOrderAt());
            log.info("총 가격: {}", dto.getTotalPrice());
            log.info("발주 상태: {}", dto.getOrderStatus());
            log.info("승인일: {}", dto.getAppAt());
            log.info("입고일: {}", dto.getStoreAt());
        }
    }

    // 3. 본사 승인
    @Test
    void 본사_발주_승인(){
        int result = orderService.approveOrder(35L);
        log.info("본사 발주 승인 : {}",result);
    }
    // 4, 본사 거절
    @Test
    void 본사_발주_거절(){
        int result = orderService.rejectOrder(35L,"곰팡이");
        log.info("본사 거절 승인 : {}",result);
    }
    // 5. 입고 처리(입고, 제조일자 변경)
    @Test
    void 직영점_입고_처리(){
        int result = orderService.updateOrderDate(35L,"2026-11-17","2026-11-19");
        log.info("직영점 입고 처리 {}",result);
    }

    @Test
    void 전체_상태_조회(){
        OrderStatusCountDTO result = orderService.countOrderStatus();
        log.info("승인 전체 상태 조회 : {}",result.getApprovedCount());
        log.info("거절 전체 상태 조회 : {}",result.getRejectedCount());
        log.info("대기 전체 상태 조회 : {}",result.getWaitingCount());
    }

    
}
