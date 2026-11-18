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

import static org.junit.jupiter.api.Assertions.*;

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
    @Transactional
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
    void 본사_발주_전체_조회(){

    }
    
    
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
    @Test
    void 발주_상세_상태_조회(){
        List<OrderStatusDTO> result = mbOrderRepository.findOrderStatusList();
        assertNotNull(result);

        for(OrderStatusDTO dto : result){
            assertNotNull(dto.getOrderId());
            assertNotNull(dto.getOrderStatus());
            log.info("발주 번호 :{}", dto.getOrderId());
            log.info("발주 상태 :{}", dto.getOrderStatus());
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

    // 1. 존재하지 않는 발주 상세 ID 승인
    @Test
    void 존재하지_않는_발주_상세_승인() {

        Long orderDetailId = 123L;

        int result = orderService.approveOrder(orderDetailId);

        assertEquals(0, result,
                "존재하지 않는 발주 상세 ID는 수정되지 않아야 한다.");

        log.info("승인 실패 테스트 - 상세 ID: {}", orderDetailId);
        log.info("승인 처리 결과: {}", result);
    }


    // 2. 존재하지 않는 발주 상세 거절
    @Test
    void 존재하지_않는_발주_상세_거절() {

        Long orderDetailId = 123L;
        String rejectReason = "재고 부족";

        int result = orderService.rejectOrder(
                orderDetailId,
                rejectReason
        );

        assertEquals(0, result,
                "존재하지 않는 발주 상세는 거절 처리되지 않아야 한다.");

        log.info("거절 실패 테스트 - 상세 ID: {}", orderDetailId);
        log.info("거절 처리 결과: {}", result);
    }


    // 3. 존재하지 않는 발주 상세 입고일자 수정
    @Test
    void 존재하지_않는_발주_상세_입고_처리() {

        Long orderDetailId = 999999999L;
        String manufactureAt = "2026-11-17";
        String storeAt = "2026-11-19";

        int result = orderService.updateOrderDate(
                orderDetailId,
                manufactureAt,
                storeAt
        );

        assertEquals(0, result,
                "존재하지 않는 발주 상세의 날짜는 수정되지 않아야 한다.");

        log.info("입고 처리 실패 테스트 - 상세 ID: {}", orderDetailId);
        log.info("입고 처리 결과: {}", result);
    }

    @Test
    void 존재하지_않는_식재료로_발주_등록_실패() {

        // Given
        Orders order = Orders.builder()
                .orderAt(Timestamp.valueOf(LocalDateTime.now()))
                .appAt(Timestamp.valueOf(LocalDateTime.now()))
                .totalPrice(0)
                .userId(1)
                .storeId(1)
                .build();

        List<OrderDetailRequestDTO> detailList = new ArrayList<>();

        OrderDetailRequestDTO detail = new OrderDetailRequestDTO();
        detail.setIngredientId(999999999L);
        detail.setOrderQuantity(10);
        detail.setSupplyPrice(2000);
        detail.setOrderPrice(20000);

        detailList.add(detail);

        assertThrows(RuntimeException.class, () -> {
            orderService.registerOrder(order, detailList);
        });

        // 발주 정보까지 롤백되었는지 확인
        assertFalse(jpaOrderRepository.existsById(order.getOrderId()));

        log.info("발주 상세 등록 실패 확인");
        log.info("존재하지 않는 식재료 ID: {}", detail.getIngredientId());
        log.info("발주 번호: {}", order.getOrderId());
        log.info("발주 정보 롤백 여부 확인 완료");
    }

    @Test
    void 상세_품목이_없는_발주_등록() {

        Orders order = Orders.builder()
                .orderAt(Timestamp.valueOf(LocalDateTime.now()))
                .appAt(Timestamp.valueOf(LocalDateTime.now()))
                .totalPrice(0)
                .userId(1)
                .storeId(1)
                .build();

        List<OrderDetailRequestDTO> detailList = new ArrayList<>();

        Long orderId = orderService.registerOrder(order, detailList);

        int count = mbOrderRepository.countOrderDetails(orderId);
        Long totalPrice = mbOrderRepository.selectOrderTotalPrice(orderId);

        assertNotNull(orderId);
        assertEquals(0, count);
        assertEquals(0L, totalPrice);

        log.info("발주 번호: {}", orderId);
        log.info("상세 품목 수: {}", count);
        log.info("발주 총금액: {}", totalPrice);
    }
}
