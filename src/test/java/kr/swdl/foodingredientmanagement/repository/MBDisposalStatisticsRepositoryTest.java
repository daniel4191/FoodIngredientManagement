package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.vo.*;
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
        List<StoreOrderDisposalRateVO> orderDisposalRatesByStore = mbDisposalStatisticsRepository.getOrderDisposalRatesByStore(null, null);
        log.info("test dump : {}", orderDisposalRatesByStore);
    }

    @Test
    public void 특정직영점_식재료별_발주_대비_폐기율() {
        List<StoreOrderDisposalRateVO> orderDisposalRatesByStore = mbDisposalStatisticsRepository.getOrderDisposalRatesByStore(null, null);
        log.info("test dump : {}", orderDisposalRatesByStore);

    }

    @Test
    public void 전체직영점_식재료별_폐기_비용() {
        List<DisposalCostByIngredientVO> disposalCostsByIngredient = mbDisposalStatisticsRepository.getDisposalCostsByIngredient(null, null);
        log.info("test dump : {}", disposalCostsByIngredient);
    }

    @Test
    public void 특정직영점_식재료별_폐기_비용() {
        List<DisposalCostByIngredientVO> disposalCostsByIngredientForStore = mbDisposalStatisticsRepository.getDisposalCostsByIngredientForStore(Long.valueOf(1), null, null);
        log.info("test dump : {}", disposalCostsByIngredientForStore);
    }

    @Test
    public void 직영점별_폐기_비용_순위() {
        List<DisposalCostRankingStoreInfoVO> storeDisposalCostRanking = mbDisposalStatisticsRepository.getStoreDisposalCostRanking(null, null);
        log.info("test dump : {}", storeDisposalCostRanking);
    }

    @Test
    public void 일자별_폐기_비용_및_수량() {
        List<DailyDisposalTotalVO> dailyDisposalTotalsForPeriod = mbDisposalStatisticsRepository.getDailyDisposalTotalsForPeriod(null, null);
        log.info("test dump : {}", dailyDisposalTotalsForPeriod);
    }


}
