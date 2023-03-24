package cn.forest.lottery.domain.strategy.service.draw;

import cn.forest.lottery.domain.award.model.Award;
import cn.forest.lottery.domain.award.repository.IAwardRepository;
import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
public class DrawStrategySupport extends DrawConfig {
    @Resource
    protected IStrategyRepository strategyRepository;

    @Resource
    protected IAwardRepository awardRepository;

    protected StrategyAggregate queryStrategyAggregateById(Long strategyId) {
        return strategyRepository.queryStrategyAggregateById(strategyId);
    }

    protected Award queryAwardByAwardId(String awardId) {
        return strategyRepository.queryAwardByAwardId(awardId);
    }
}
