package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.repository.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MBDisposalStatisticsRepository {

    double getOrderDisposalRateUntilNow(@Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);

    List<StoreOrderDisposalRateVO> getOrderDisposalRatesByStore(@Param("startDate") LocalDate startDate,
                                                                @Param("endDate") LocalDate endDate);

    List<IngredientDisposalRateToOrderByStoreVO> getStoreIngredientDisposalRates(@Param("storeId")Long storeId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<DisposalCostByIngredientVO> getDisposalCostsByIngredient(@Param("startDate") LocalDate startDate,
                                                                  @Param("endDate") LocalDate endDate);

    List<DisposalCostByIngredientVO> getDisposalCostsByIngredientForStore(@Param("storeId") Long storeId,  @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<DisposalCostRankingStoreInfoVO> getStoreDisposalCostRanking(@Param("startDate") LocalDate startDate,
                                                                     @Param("endDate") LocalDate endDate);

    List<DailyDisposalTotalVO> getDailyDisposalTotalsForPeriod(@Param("startDate") LocalDate startDate,
                                                               @Param("endDate") LocalDate endDate);
}
