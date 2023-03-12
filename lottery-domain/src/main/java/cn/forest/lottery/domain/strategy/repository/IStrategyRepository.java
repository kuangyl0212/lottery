package cn.forest.lottery.domain.strategy.repository;

import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.infrastructure.po.Award;
import cn.forest.lottery.infrastructure.po.StrategyDetail;

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

    Award queryAwardInfoByAwardId(String awardId);

    List<StrategyDetail> queryNonStockAwardIds(Long strategyId);

}
