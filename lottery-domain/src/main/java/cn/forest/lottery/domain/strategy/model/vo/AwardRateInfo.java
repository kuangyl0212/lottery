package cn.forest.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Data
public class AwardRateInfo {
    private String awardId;
    private BigDecimal awardRate;

    public AwardRateInfo(Long awardId, BigDecimal awardRate) {
        this.awardId = awardId.toString();
        this.awardRate = awardRate;
    }
}
