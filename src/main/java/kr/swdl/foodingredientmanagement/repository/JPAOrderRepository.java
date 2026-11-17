package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.entitiy.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAOrderRepository extends JpaRepository<Orders, Long> {
}
