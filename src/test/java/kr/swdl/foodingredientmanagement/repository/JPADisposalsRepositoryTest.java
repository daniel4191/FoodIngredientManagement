package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.entitiy.Disposals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@SpringBootTest
public class JPADisposalsRepositoryTest {

    @Autowired
    private JPADisposalsRepository jpaDisposalsRepository;

    @Test
    @Transactional
    public void 본사_폐기_등록() {
        Disposals disposal = Disposals.builder()
//                .disposalId(//)
                .disposalUnit("통폐기")
                .disposalReqAt(Timestamp.valueOf("2026-11-09 10:00:00"))
                .reqUserId(Long.valueOf(1))
                .disposalStatus("승인")
                .processingMethod("정기폐기")
                .disposalType("식재료 규칙")
                .disposalReason("유통기한 경과")
                .disposalDetailReason(null)
                .rejectReason(null)
                .disposalQuantity(1)
                .disposalPrice(7980)
                .orderDetailId(Long.valueOf(1))
                .build();

        Assertions.assertNotNull(jpaDisposalsRepository.save(disposal));
    }

    @Test
    @Transactional
    public void 직영점_폐기_등록() {
        Disposals disposal = Disposals.builder()
//                .disposalId(//)
                .disposalUnit("통폐기")
                .disposalReqAt(Timestamp.valueOf("2026-11-09 10:00:00"))
                .reqUserId(Long.valueOf(1))
                .disposalStatus("요청")
                .processingMethod("정기폐기")
                .disposalType("식재료 규칙")
                .disposalReason("유통기한 경과")
                .disposalDetailReason(null)
                .rejectReason(null)
                .disposalQuantity(1)
                .disposalPrice(7980)
                .orderDetailId(Long.valueOf(1))
                .build();

        Assertions.assertNotNull(jpaDisposalsRepository.save(disposal));
    }

    @Test
    @Transactional
    public void 특정_폐기_조회() {
        Assertions.assertFalse(jpaDisposalsRepository.findById(Long.valueOf(1)).isEmpty());
        // TODO: Service 계층에서 특정 폐기 조회를 통해 컬럼값을 가져와 수정가능한 상태인지 확인
    }

    @Test
    @Transactional
    public void 폐기_수정() {
        Optional<Disposals> optionalDisposal = jpaDisposalsRepository.findById(Long.valueOf(1));
        Assertions.assertFalse(optionalDisposal.isEmpty());
        Disposals disposal = optionalDisposal.get();

        disposal.setDisposalType("식재료규칙2");
        disposal.setDisposalReason("12341234");
        disposal.setDisposalDetailReason("@@@@@");
        disposal.setDisposalQuantity(53);

        Disposals saved = jpaDisposalsRepository.save(disposal);
        Assertions.assertEquals(saved, disposal);
    }

    @Test
    @Transactional
    public void 폐기_삭제() {
        Assertions.assertFalse(jpaDisposalsRepository.findById(Long.valueOf(1)).isEmpty());
        jpaDisposalsRepository.deleteById(Long.valueOf(1));
        Assertions.assertTrue(jpaDisposalsRepository.findById(Long.valueOf(1)).isEmpty());
    }

    @Test
    @Transactional
    public void 폐기_상세_조회() {
        // TODO: 서비스 계층에서 진행
    }

    @Test
    @Transactional
    public void 폐기_요청_승인() {
        // TODO: 서비스 계층에서 진행
    }

    @Test
    @Transactional
    public void 폐기_요청_승인_거절() {
        // TODO: 서비스 계층에서 진행
    }

    @Test
    public void 폐기상태_요청_조회() {
        // TODO: 서비스 계층에서 진행
    }


}
