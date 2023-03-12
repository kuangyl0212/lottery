package cn.forest.lottery.domain.strategy.service.draw.impl;

import cn.forest.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.forest.lottery.domain.strategy.service.draw.AbstractDrawBase;
import cn.forest.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */

@Service(value = "drawExec")
public class DrawExecImpl extends AbstractDrawBase {
    @Override
    protected List<Long> queryExcludeAwardsIds(Long strategyId) {

        List<StrategyDetail> excludeAwards = strategyRepository.queryNonStockAwardIds(strategyId);

        return excludeAwards.stream().map(StrategyDetail::getAwardId).collect(Collectors.toList());
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<Long> excludeAwardsIds) {
        return drawAlgorithm.drawRandom(strategyId, excludeAwardsIds);
    }
}
