package cn.forest.lottery.domain.strategy.service.algorithm;

import cn.forest.lottery.domain.strategy.model.vo.AwardRateInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Forest
 */
@Component
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm implements IDrawAlgorithm {

    @Override
    public String drawRandom(Long strategyId, List<String> excludeAwardIds) {
        List<AwardRateInfo> awardRateInfoList = awardRateInfoMap.get(strategyId);

        List<AwardRateInfo> awardRateInfoIncludedList = new ArrayList<>();

        BigDecimal rateSum = BigDecimal.ZERO;

        for (AwardRateInfo awardRateInfo: awardRateInfoList) {
            if (excludeAwardIds.contains(awardRateInfo.getAwardId())) {
                continue;
            }
            awardRateInfoIncludedList.add(awardRateInfo);
            rateSum = rateSum.add(awardRateInfo.getAwardRate());
        }

        String resAwardId = "";

        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100);
        int cursor = 0;

        for (AwardRateInfo awardRateInfo: awardRateInfoIncludedList) {
            cursor = cursor + awardRateInfo.getAwardRate().divide(rateSum, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal("100")).intValue();
            if (randomVal <= cursor) {
                resAwardId = awardRateInfo.getAwardId();
                break;
            }
        }

        return resAwardId;
    }
}
