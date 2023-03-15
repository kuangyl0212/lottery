package cn.forest.lottery.domain.strategy.service.draw;

import cn.forest.lottery.domain.strategy.model.*;
import cn.forest.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.forest.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import java.util.ArrayList;
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

        if (strategyAggregate.getStrategy() == null) {
            return new DrawResult();
        }
        Strategy strategy = strategyAggregate.getStrategy();
        // 2.检查抽奖策略是否已经加载到内存
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyAggregate.getDetails());
        // 3. 获取不在抽奖范围内的奖品列表
        List<String> excludeAwardIds = this.queryExcludeAwardsIds(strategyId);
        // 4. 执行抽奖算法

         String awardId = this.drawAlgorithm(strategyId, drawAlgorithmMap.get(strategyAggregate.getStrategyMode()), excludeAwardIds);
         // 5. 扣减库存
        boolean isSuccess = strategyRepository.decreaseStock(strategyId, awardId);
        DrawResult res = new DrawResult();
        res.setAwardId(awardId);
        return res;
    }

    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetails) {
        if (strategyMode == 1) {
            return;
        }
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);


        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetails.size());
        for (StrategyDetail strategyDetail: strategyDetails) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

    /**
     * 查询需要排除的奖品id列表
     * @param strategyId 抽奖策略id
     * @return 排除的奖品列表
     */
    protected abstract List<String> queryExcludeAwardsIds(Long strategyId);

    /**
     * 执行抽奖算法
     * @param strategyId 抽奖策略id
     * @param drawAlgorithm 抽奖算法
     * @param excludeAwardsIds 需要排除的奖品列表
     * @return 抽奖结果
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardsIds);
}
