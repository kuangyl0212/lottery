package cn.forest.lottery.domain.strategy.service.algorithm;

import cn.forest.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Forest
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm {

    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    @Override
    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);
    }
}
