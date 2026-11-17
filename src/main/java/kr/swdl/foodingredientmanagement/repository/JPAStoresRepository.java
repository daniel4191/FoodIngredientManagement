package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.entitiy.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAStoresRepository extends JpaRepository<Stores, Long> {
}
