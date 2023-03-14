package cn.forest.lottery.domain.support.ids;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.support.ids.policy.RandomNumeric;
import cn.forest.lottery.domain.support.ids.policy.ShortCode;
import cn.forest.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/13
 */
@Configuration
public class IdContext {
    @Bean
    public Map<LotteryConstants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric) {
        Map<LotteryConstants.Ids, IIdGenerator> idGeneratorMap = new HashMap<>(3);
        idGeneratorMap.put(LotteryConstants.Ids.SnowFlake, snowFlake);
        idGeneratorMap.put(LotteryConstants.Ids.ShortCode, shortCode);
        idGeneratorMap.put(LotteryConstants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorMap;
    }
}
