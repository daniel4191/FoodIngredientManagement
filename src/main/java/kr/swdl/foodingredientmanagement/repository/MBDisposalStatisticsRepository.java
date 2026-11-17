package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MBDisposalStatisticsRepository {

    double getOrderDisposalRateUntilNow(@Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);

    List<StoreOrderDisposalRateDTO> getOrderDisposalRatesByStore(@Param("startDate") LocalDate startDate,
                                                                 @Param("endDate") LocalDate endDate);

    List<IngredientDisposalRateToOrderByStoreDTO> getStoreIngredientDisposalRates(@Param("storeId")Long storeId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<DisposalCostByIngredientDTO> getDisposalCostsByIngredient(@Param("startDate") LocalDate startDate,
                                                                   @Param("endDate") LocalDate endDate);

    List<DisposalCostByIngredientDTO> getDisposalCostsByIngredientForStore(@Param("storeId") Long storeId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<DisposalCostRankingStoreInfoDTO> getStoreDisposalCostRanking(@Param("startDate") LocalDate startDate,
                                                                      @Param("endDate") LocalDate endDate);

    List<DailyDisposalTotalDTO> getDailyDisposalTotalsForPeriod(@Param("startDate") LocalDate startDate,
                                                                @Param("endDate") LocalDate endDate);
}
