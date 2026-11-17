package kr.swdl.foodingredientmanagement.service;

import jakarta.transaction.Transactional;
import kr.swdl.foodingredientmanagement.dto.OrderDetailRequestDTO;
import kr.swdl.foodingredientmanagement.repository.JPAOrderRepository;
import kr.swdl.foodingredientmanagement.repository.MBOrderRepository;
import kr.swdl.foodingredientmanagement.repository.entitiy.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final JPAOrderRepository ordersRepository;
    private final MBOrderRepository mbOrderRepository;

    // 등록 서비스 테스트 구현중
    @Transactional
    public Long registerOrder(
            Orders order,
            List<OrderDetailRequestDTO> detailList) {

        Orders savedOrder = ordersRepository.save(order);

        Long orderId = savedOrder.getOrderId();

        for (OrderDetailRequestDTO detail : detailList) {

            detail.setOrderId(orderId);

            int result = mbOrderRepository.insertOrderDetail(detail);

            if (result != 1) {
                throw new IllegalStateException("상세 품목 등록 실패");
            }
        }

        int result = mbOrderRepository.updateOrderTotalPrice(orderId);

        if (result != 1) {
            throw new IllegalStateException("총금액 갱신 실패");
        }

        return orderId;
    }
}
