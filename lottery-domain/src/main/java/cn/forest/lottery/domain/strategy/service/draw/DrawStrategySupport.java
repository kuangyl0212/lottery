package cn.forest.lottery.domain.strategy.service.draw;

import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.domain.strategy.repository.IStrategyRepository;
import cn.forest.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
public class DrawStrategySupport extends DrawConfig {
    @Resource
    protected IStrategyRepository strategyRepository;

    protected StrategyAggregate queryStrategyAggregateById(Long strategyId) {
        return strategyRepository.queryStrategyAggregateById(strategyId);
    }

    protected Award queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfoByAwardId(awardId);
    }
}
