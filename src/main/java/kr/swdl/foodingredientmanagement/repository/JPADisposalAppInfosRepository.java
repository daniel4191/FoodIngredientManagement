package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.entitiy.DisposalAppInfos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPADisposalAppInfosRepository extends JpaRepository<DisposalAppInfos, Long> {

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("""
        UPDATE DisposalAppInfos dai
        SET dai.checkAt = CURRENT_TIMESTAMP,
            dai.disposalImg = :disposalImg,
            dai.checkUserId = :checkUserId
        WHERE dai.disposalAppInfoId = :disposalAppInfoId
        """)
    int updateDisposalAppInfo(
            @Param("disposalAppInfoId") Long disposalAppInfoId,
            @Param("disposalImg") byte[] disposalImg,
            @Param("checkUserId") Long checkUserId);

    Optional<DisposalAppInfos> findByDisposalId(Long disposalId);
}
