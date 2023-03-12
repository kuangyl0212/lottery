package cn.forest.lottery.domain.strategy.service.draw;

import cn.forest.lottery.domain.strategy.service.algorithm.DefaultRateRandomDrawAlgorithm;
import cn.forest.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.forest.lottery.domain.strategy.service.algorithm.SingleRateRandomDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
public class DrawConfig {

    @Resource
    DefaultRateRandomDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    SingleRateRandomDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(0, defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(1, singleRateRandomDrawAlgorithm);
    }
}
