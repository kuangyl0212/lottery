package cn.forest.lottery.domain.strategy.repository;

import cn.forest.lottery.domain.award.model.Award;
import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.domain.strategy.model.StrategyDetail;


import java.util.List;


/**
 * @author Forest
 */
public interface IStrategyRepository {
    /**
     * 查询抽奖策略聚合
     * @param strategyId 策略id
     * @return 策略聚合
     */
    StrategyAggregate queryStrategyAggregateById(Long strategyId);

    Award queryAwardByAwardId(String awardId);

    List<StrategyDetail> queryNonStockAwardIds(Long strategyId);

    boolean decreaseStock(Long strategyId, String awardId);
}
