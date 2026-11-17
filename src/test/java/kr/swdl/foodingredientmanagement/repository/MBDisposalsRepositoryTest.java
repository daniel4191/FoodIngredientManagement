package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.HQDisposalDTO;
import kr.swdl.foodingredientmanagement.dto.HqDisposalSerachFilterDTO;
import kr.swdl.foodingredientmanagement.dto.StoreDisposalDTO;
import kr.swdl.foodingredientmanagement.dto.StoreDisposalSerachFilterDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
public class MBDisposalsRepositoryTest {

    @Autowired
    private MBDisposalsRepository mbDisposalsRepository;


    @Test
    public void 본사_폐기_목록조회() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        log.info("{}", disposals.size());
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_오름차순() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType("asc").build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_내림차순() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType("desc").build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_직영점이름() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName("잠실직영점")
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_식재료명() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName("계란")
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_요청상태() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus("요청")
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_시작종료일() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate("2026-11-09")
                .endDate("2026-11-1")
                .disposalType(null)
                .processingMethod(null)
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_폐기타입() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType("위생(변질)")
                .processingMethod(null)
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    public void 본사_폐기_목록조회_전체_정규수시() {
        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod("정기폐기")
                .userId(2L)
                .sortType(null).build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }


    @Test
    public void 본사_폐기_목록조회_전체_모든필터_적용() {

        HqDisposalSerachFilterDTO filterDTO = HqDisposalSerachFilterDTO.builder()
                .storeName("강남직영점")
                .ingredientName("계")
                .disposalStatus("승인")
                .startDate("2026-11-09")
                .endDate("2026-11-11")
                .disposalType("입고 품질 불량")
                .processingMethod("정기폐기")
                .userId(2L)
                .sortType("desc").build();
        List<HQDisposalDTO> disposals = mbDisposalsRepository.getHqDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
    }

    @Test
    @Transactional
    public void 금일_폐기_건수() {
        // 테스트 폐기 추가
        System.out.println(mbDisposalsRepository.countByTodayDisposed());
    }

    @Test
    @Transactional
    public void 금일_폐기_금액() {
        System.out.println(mbDisposalsRepository.sumByTodayDisposedPrice());
    }

    @Test
    @Transactional
    public void 금일_폐기확인필요_개수() {
        System.out.println(mbDisposalsRepository.countNeedToConfirmByStoreId(3));
    }

    @Test
    public void 직영점_폐기목록_조회() {
        StoreDisposalSerachFilterDTO filterDTO = StoreDisposalSerachFilterDTO.builder()
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .processingMethod(null)
                .storeId(1L)
                .sortType(null).build();
        List<StoreDisposalDTO> disposals = mbDisposalsRepository.getStoreDisposals(filterDTO);
        System.out.println(disposals);
        Assertions.assertTrue(disposals.size() >= 0);
    }

}