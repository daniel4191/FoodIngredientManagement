package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.entitiy.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAUsersRepository extends JpaRepository<Users,Long> {
}
