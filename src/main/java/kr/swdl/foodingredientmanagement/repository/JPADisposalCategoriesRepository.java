package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.entitiy.DisposalCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPADisposalCategoriesRepository extends JpaRepository<DisposalCategories, Long> {


    List<DisposalCategories> findAllByDisposalType(String disposalType);
}
