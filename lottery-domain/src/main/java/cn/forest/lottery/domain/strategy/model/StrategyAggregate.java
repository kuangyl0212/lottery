package cn.forest.lottery.domain.strategy.model;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */

@Data
public class StrategyAggregate {
    Long strategyId;
    Strategy strategy;
    List<StrategyDetail> details;

    public StrategyAggregate(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetails) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.details = strategyDetails;
    }

    public Integer getStrategyMode() {
        return strategy.getStrategyMode();
    }
}
