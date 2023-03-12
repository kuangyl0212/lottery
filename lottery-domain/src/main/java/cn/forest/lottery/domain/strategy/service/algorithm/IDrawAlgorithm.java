package cn.forest.lottery.domain.strategy.service.algorithm;

import java.util.List;

/**
 * @author Forest
 */
public interface IDrawAlgorithm {
    /**
     * 随机抽奖
     * @param strategyId 抽奖策略ID
     * @param excludeAwardIds 排除的奖品ID列表
     * @return 抽奖结果
     */
    String drawRandom(Long strategyId, List<Long> excludeAwardIds);
}
