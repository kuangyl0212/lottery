package cn.forest.lottery.domain.award.service.goods.impl;

import cn.forest.lottery.domain.award.model.DistributeRes;
import cn.forest.lottery.domain.award.model.GoodsReq;
import cn.forest.lottery.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Forest
 * @date 2023/3/15 12:40
 */
@Slf4j
@Component
public class OtherGoods implements IDistributionGoods {
    @Override
    public DistributeRes doDistribution(GoodsReq req) {
        log.info("distribute goods");
        return null;
    }
}
