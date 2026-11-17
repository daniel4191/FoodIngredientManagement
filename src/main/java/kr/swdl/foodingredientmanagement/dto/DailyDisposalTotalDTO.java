package kr.swdl.foodingredientmanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class DailyDisposalTotalDTO {
    private Timestamp disposalDate;
    private int disposalCount;
    private int totalDisposalQuantity;
    private int totalDisposalPrice;
}
