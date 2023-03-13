package cn.forest.lottery.domain.award.service.factory;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.award.service.goods.IDistributionGoods;
import cn.forest.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.forest.lottery.domain.award.service.goods.impl.PhysicalGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Forest
 * @date 2023/3/13 10:47
 */
public class DistributionServiceFactoryConfig {
    protected static Map<Integer, IDistributionGoods> distributionServiceMap = new ConcurrentHashMap<>();

    @Resource
    CouponGoods couponGoods;
    @Resource
    PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        distributionServiceMap.put(LotteryConstants.AwardType.CouponGoods.getCode(), couponGoods);
        distributionServiceMap.put(LotteryConstants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}
