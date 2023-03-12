package cn.forest.lottery.domain.strategy.service.algorithm;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Forest
 */

@Component
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm implements IDrawAlgorithm {
    @Override
    public String drawRandom(Long strategyId, List<Long> excludeAwardIds) {
        return null;
    }
}
