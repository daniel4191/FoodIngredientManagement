package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.DailyDisposalTotalDTO;
import kr.swdl.foodingredientmanagement.dto.DisposalCostByIngredientDTO;
import kr.swdl.foodingredientmanagement.dto.DisposalCostRankingStoreInfoDTO;
import kr.swdl.foodingredientmanagement.dto.StoreOrderDisposalRateDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MBDisposalStatisticsRepositoryTest {

    @Autowired
    private MBDisposalStatisticsRepository mbDisposalStatisticsRepository;

    @Test
    public void 발주대비_폐기율_현재일시_누적() {
        double rate = mbDisposalStatisticsRepository.getOrderDisposalRateUntilNow(null, null);
        log.info("test dump : {}", rate);
    }

    @Test
    public void 직영점별_발주_대비_폐기율() {
        List<StoreOrderDisposalRateDTO> orderDisposalRatesByStore = mbDisposalStatisticsRepository.getOrderDisposalRatesByStore(null, null);
        log.info("test dump : {}", orderDisposalRatesByStore);
    }

    @Test
    public void 특정직영점_식재료별_발주_대비_폐기율() {
        List<StoreOrderDisposalRateDTO> orderDisposalRatesByStore = mbDisposalStatisticsRepository.getOrderDisposalRatesByStore(null, null);
        log.info("test dump : {}", orderDisposalRatesByStore);

    }

    @Test
    public void 전체직영점_식재료별_폐기_비용() {
        List<DisposalCostByIngredientDTO> disposalCostsByIngredient = mbDisposalStatisticsRepository.getDisposalCostsByIngredient(null, null);
        log.info("test dump : {}", disposalCostsByIngredient);
    }

    @Test
    public void 특정직영점_식재료별_폐기_비용() {
        List<DisposalCostByIngredientDTO> disposalCostsByIngredientForStore = mbDisposalStatisticsRepository.getDisposalCostsByIngredientForStore(Long.valueOf(1), null, null);
        log.info("test dump : {}", disposalCostsByIngredientForStore);
    }

    @Test
    public void 직영점별_폐기_비용_순위() {
        List<DisposalCostRankingStoreInfoDTO> storeDisposalCostRanking = mbDisposalStatisticsRepository.getStoreDisposalCostRanking(null, null);
        log.info("test dump : {}", storeDisposalCostRanking);
    }

    @Test
    public void 일자별_폐기_비용_및_수량() {
        List<DailyDisposalTotalDTO> dailyDisposalTotalsForPeriod = mbDisposalStatisticsRepository.getDailyDisposalTotalsForPeriod(null, null);
        log.info("test dump : {}", dailyDisposalTotalsForPeriod);
    }


}
