package kr.swdl.foodingredientmanagement.service;

import jakarta.persistence.*;
import kr.swdl.foodingredientmanagement.repository.JPADisposalAppInfosRepository;
import kr.swdl.foodingredientmanagement.repository.JPADisposalCategoriesRepository;
import kr.swdl.foodingredientmanagement.repository.JPADisposalsRepository;
import kr.swdl.foodingredientmanagement.repository.MBDisposalsRepository;
import kr.swdl.foodingredientmanagement.repository.entitiy.DisposalAppInfos;
import kr.swdl.foodingredientmanagement.repository.entitiy.Disposals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@SpringBootTest
public class DisposalServiceTest {

    @Autowired
    private JPADisposalAppInfosRepository jpaDisposalAppInfosRepository;
    @Autowired
    private JPADisposalCategoriesRepository jpaDisposalCategoriesRepository;
    @Autowired
    private JPADisposalsRepository jpaDisposalsRepository;
    @Autowired
    private MBDisposalsRepository mbDisposalsRepository;

    @Test
    @Transactional
    public void 본사_폐기_등록() {
        Disposals disposal = Disposals.builder()
                .disposalUnit("통폐기")
                .disposalReqAt(new Timestamp(System.currentTimeMillis()))
                .reqUserId(Long.valueOf(1))
                .disposalStatus("승인")
                .processingMethod("정기폐기")
                .disposalType("식재료 규칙")
                .disposalReason("유통기한 경과")
                .disposalQuantity(1)
                .disposalPrice(7980)
                .orderDetailId(Long.valueOf(1))
                .build();

        Assertions.assertNotNull(jpaDisposalsRepository.save(disposal));
    }

    @Test
    public void 삭제수정전_상태_확인() {
        // 1. 특정 폐기 아이디 받기
        Long disposalId = Long.valueOf(1);
        Optional<Disposals> optionalDisposal = jpaDisposalsRepository.findById(disposalId);
        if (optionalDisposal.isEmpty()) Assertions.fail();

        if (optionalDisposal.get().getDisposalStatus() == "요청") {
            // return true;
        }
    }

    // 폐기유형_폐기사유_폐기상세사유_폐기수량
    @Test
    public void 폐기_수정() {
    }

    @Test
    public void 폐기_삭제_성공() {
        // 1. 특정 폐기 아이디 받기
        Long disposalId = Long.valueOf(1);
        Optional<Disposals> optionalDisposal = jpaDisposalsRepository.findById(disposalId);
        if (optionalDisposal.isEmpty()) Assertions.fail();
        if (optionalDisposal.get().getDisposalStatus().equals("요청")) {
            jpaDisposalsRepository.deleteById(disposalId);
        } else {
            Assertions.fail();
        }
    }

    @Test
    public void 폐기_삭제_실패() {
        // 1. 특정 폐기 아이디 받기
        Long disposalId = Long.valueOf(9999);
        Optional<Disposals> optionalDisposal = jpaDisposalsRepository.findById(disposalId);
        if (optionalDisposal.isEmpty()) {
            return;
        }
        Assertions.fail();
    }

    @Test
    public void 폐기_목록_조회() {
    }

//    @Test
//    public void 폐기_상세_조회() {
//        // 1. 특정 폐기 아이디 받기
//        Long disposalId = Long.valueOf(1);
//
//        // 폐기
//        Disposals disposal = jpaDisposalsRepository.findById(disposalId)
//                .orElseThrow(() -> new EntityNotFoundException(
//                        "폐기 정보를 찾을 수 없습니다. disposalId=" + disposalId));
//
//        // 폐기 승인·확인 정보
//        Optional<DisposalAppInfos> optionalDisposalAppInfo = jpaDisposalAppInfosRepository.findByDisposalId(disposalId);
//
//        // 폐기 요청 직원
//        Optional<Users> requestUser = jpaUsersRepository.findById(disposal.getReqUserId());
//
//        // 폐기 승인 직원
//        String appUserName = null;
//        String checkUserName = null;
//        Timestamp checkAt = null;
//        byte[] disposalImg = null;
//        if (optionalDisposalAppInfo.isPresent()) {
//            DisposalAppInfos disposalAppInfo = optionalDisposalAppInfo.get();
//            Long appUserId = disposalAppInfo.getAppUserId();
//            // TODO: 이름정보 얻기
//            Long checkUserId = disposalAppInfo.getCheckUserId();
//            // TODO: 이름정보 얻기
//
//            checkAt = disposalAppInfo.getCheckAt();
//            disposalImg = disposalAppInfo.getDisposalImg();
//        }
//
//        // 폐기 확인 직원
//        Optional<Users> checkUser = disposalAppInfo
//                .map(DisposalAppInfos::getCheckUserId)
//                .flatMap(jpaUsersRepository::findById);
//
//        // 발주 상세
//        Optional<OrderDetails> orderDetail = Optional.ofNullable(disposal.getOrderDetailId())
//                .flatMap(jpaOrderDetailsRepository::findById);
//
//        // 발주
//        Optional<Orders> order = orderDetail
//                .map(OrderDetails::getOrderId)
//                .flatMap(jpaOrdersRepository::findById);
//
//        // 직영점
//        Optional<Stores> store = order
//                .map(Orders::getStoreId)
//                .flatMap(jpaStoresRepository::findById);
//
//        // 식재료
//        Optional<Ingredients> ingredient = orderDetail
//                .map(OrderDetails::getIngredientId)
//                .flatMap(jpaIngredientsRepository::findById);
//    }

    @Test
    public void 폐기_요청_승인() {
    }

    @Test
    public void 폐기_요청_거절() {
    }

    @Test
    public void 폐기_승인_정보_테이블_생성() {
    }

    @Test
    public void 승인대기_애매하네() {
    }

    @Test
    public void 금일_폐기_건수() {
    }

    @Test
    public void 금일_총폐기_금액() {
    }

    @Test
    public void 직영점_폐기_등록() {
    }

    @Test
    public void 삭제_수정_전_상태_확인() {
    }

    @Test
    public void 폐기_승인_정보_업데이트() {
    }

    @Test
    public void 확인_필요한_폐기_건수() {
    }

    @Test
    public void 폐기유형_대분류_가져오기() {
    }


}
