package cn.forest.lottery.domain.strategy.service.draw;

import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.forest.lottery.infrastructure.po.StrategyDetail;
import cn.forest.lottery.rpc.req.DrawReq;
import cn.forest.lottery.rpc.res.DrawResult;

import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        // 1. 获取抽奖策略
        Long strategyId = req.getStrategyId();
        StrategyAggregate strategyAggregate = super.queryStrategyAggregateById(strategyId);
        // 2.
        // 3. 获取不在抽奖范围内的奖品列表
        List<Long> excludeAwardIds = this.queryExcludeAwardsIds(strategyId);
        // 4. 执行抽奖算法

         String awardId = this.drawAlgorithm(strategyId, drawAlgorithmMap.get(strategyAggregate.getStrategyMode()), excludeAwardIds);
        DrawResult res = new DrawResult();
        res.setAwardId(awardId);
        return res;
    }

    /**
     * 查询需要排除的奖品id列表
     * @param strategyId 抽奖策略id
     * @return 排除的奖品列表
     */
    protected abstract List<Long> queryExcludeAwardsIds(Long strategyId);

    /**
     * 执行抽奖算法
     * @param strategyId 抽奖策略id
     * @param drawAlgorithm 抽奖算法
     * @param excludeAwardsIds 需要排除的奖品列表
     * @return 抽奖结果
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<Long> excludeAwardsIds);
}
