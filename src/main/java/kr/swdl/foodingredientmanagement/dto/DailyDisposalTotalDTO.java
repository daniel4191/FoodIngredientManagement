package kr.swdl.foodingredientmanagement.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DailyDisposalTotalDTO {
    private Timestamp disposalDate;
    private int disposalCount;
    private int totalDisposalQuantity;
    private int totalDisposalPrice;
}
