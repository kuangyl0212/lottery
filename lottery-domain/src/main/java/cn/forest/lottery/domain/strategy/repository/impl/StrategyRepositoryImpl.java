package cn.forest.lottery.domain.strategy.repository.impl;

import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.domain.strategy.repository.IStrategyRepository;
import cn.forest.lottery.infrastructure.po.Award;
import cn.forest.lottery.infrastructure.po.Strategy;
import cn.forest.lottery.infrastructure.po.StrategyDetail;
import cn.forest.lottery.infrastructure.repository.AwardRepository;
import cn.forest.lottery.infrastructure.repository.StrategyDetailRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Component
public class StrategyRepositoryImpl implements IStrategyRepository {

    @Resource
    cn.forest.lottery.infrastructure.repository.StrategyRepository strategyRepository;

    @Resource
    StrategyDetailRepository strategyDetailRepository;

    @Resource
    AwardRepository awardRepository;

    @Override
    public StrategyAggregate queryStrategyAggregateById(Long strategyId) {
        Strategy strategy = strategyRepository.queryByStrategyId(strategyId);
        List<StrategyDetail> strategyDetails = strategyDetailRepository.listByStrategyId(strategyId);
        return new StrategyAggregate(strategyId, strategy, strategyDetails);
    }

    @Override
    public Award queryAwardInfoByAwardId(String awardId) {
        return awardRepository.getById(awardId);
    }

    @Override
    public List<StrategyDetail> queryNonStockAwardIds(Long strategyId) {
        return strategyRepository.queryNonStockAwardIds(strategyId);
    }
}
