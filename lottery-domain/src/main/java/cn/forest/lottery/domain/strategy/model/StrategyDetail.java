package cn.forest.lottery.domain.strategy.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Forest
 * @date 2023/3/15 9:55
 */
@Data
public class StrategyDetail {
    private Long id;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品ID
     */
    private Long awardId;

    /**
     * 奖品数量
     */
    private Integer awardCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 奖品剩余库存
     */
    private Integer awardSurplusCount;
}
