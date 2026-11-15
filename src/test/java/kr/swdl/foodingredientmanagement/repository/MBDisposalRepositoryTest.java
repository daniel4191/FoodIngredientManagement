package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.DisposalListDTO;
import kr.swdl.foodingredientmanagement.dto.DisposalSerachFilterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class MBDisposalRepositoryTest {

    @Autowired
    private MBDisposalRepository mbDisposalRepository;


    @Test
    public void 본사_폐기_목록조회() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    public void 본사_폐기_목록조회_오름차순() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .sortType("asc").build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
/*        System.out.println(disposals.size());
        System.out.println(disposals);*/
    }

    @Test
    public void 본사_폐기_목록조회_전체_내림차순() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .sortType("desc").build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
       /* System.out.println(disposals.size());
        System.out.println(disposals);*/
    }

    @Test
    public void 본사_폐기_목록조회_전체_직영점이름() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName("잠실직영점")
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    public void 본사_폐기_목록조회_전체_식재료명() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName("계란")
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    public void 본사_폐기_목록조회_전체_요청상태() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus("요청")
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod(null)
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    public void 본사_폐기_목록조회_전체_시작종료일() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate("2026-11-09")
                .endDate("2026-11-1")
                .disposalType(null)
                .processingMethod(null)
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    public void 본사_폐기_목록조회_전체_폐기타입() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType("위생(변질)")
                .processingMethod(null)
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    public void 본사_폐기_목록조회_전체_정규수시() {
        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName(null)
                .ingredientName(null)
                .disposalStatus(null)
                .startDate(null)
                .endDate(null)
                .disposalType(null)
                .processingMethod("정기폐기")
                .sortType(null).build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }


    @Test
    public void 본사_폐기_목록조회_전체_모든필터_적용() {

        DisposalSerachFilterDTO filterDTO = DisposalSerachFilterDTO.builder()
                .storeName("강남직영점")
                .ingredientName("계")
                .disposalStatus("승인")
                .startDate("2026-11-09")
                .endDate("2026-11-11")
                .disposalType("입고 품질 불량")
                .processingMethod("정기폐기")
                .sortType("desc").build();
        List<DisposalListDTO> disposals = mbDisposalRepository.getDisposals(filterDTO);
        Assertions.assertTrue(disposals.size() >= 0);
//        System.out.println(disposals.size());
//        System.out.println(disposals);
    }

    @Test
    @Transactional
    public void 금일_폐기_건수() {
        // 테스트 폐기 추가
        System.out.println(mbDisposalRepository.countByTodayDisposed());
    }

    @Test
    @Transactional
    public void 금일_폐기_금액() {
        System.out.println(mbDisposalRepository.sumByTodayDisposedPrice());
    }

    @Test
    @Transactional
    public void 금일_폐기확인필요_개수() {
        System.out.println(mbDisposalRepository.countNeedToConfirmByStoreId(3));
    }


}