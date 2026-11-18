package kr.swdl.foodingredientmanagement.service;

import jakarta.transaction.Transactional;
import kr.swdl.foodingredientmanagement.dto.OrderDTO;
import kr.swdl.foodingredientmanagement.dto.OrderDetailRequestDTO;
import kr.swdl.foodingredientmanagement.dto.OrderStatusCountDTO;
import kr.swdl.foodingredientmanagement.dto.OrderStatusDTO;
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
@Transactional
public class OrderService {
    private final JPAOrderRepository jpaOrderRepository;
    private final MBOrderRepository mbOrderRepository;

    public Long registerOrder(Orders order, List<OrderDetailRequestDTO> detailList) {
        Orders savedOrder = jpaOrderRepository.save(order);

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

    public int approveOrder(Long orderDetailId) {
        int result = mbOrderRepository.approveOrderDetail(orderDetailId);
        return result;
    }

    public int rejectOrder(Long orderDetailId, String rejectReason){
        int result = mbOrderRepository.rejectOrderDetail(orderDetailId, rejectReason) ;
        return result;
    }

    public int updateOrderDate(Long orderDetailId, String manufactureAt, String storeAt) {
        int result = mbOrderRepository.updateOrderDetailsDates(orderDetailId, manufactureAt, storeAt);
        return result;
    }

    public OrderStatusCountDTO countOrderStatus(){

        return mbOrderRepository.countOrderStatus();
    }

    public List<OrderStatusDTO> findOrderStatusList(){
        return mbOrderRepository.findOrderStatusList();
    }

    public List<OrderDTO> findOrderList(){
        return mbOrderRepository.findOrderList();
    }
}
