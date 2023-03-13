package cn.forest.lottery.domain.award.service.goods;

import cn.forest.lottery.domain.award.model.DistributeRes;
import cn.forest.lottery.domain.award.model.GoodsReq;

/**
 * @author Forest
 * @date 2023/3/13 10:37
 */
public interface IDistributionGoods {

    /**
     * 发奖
     * @param req 奖品
     * @return 发奖结果
     */
    DistributeRes doDistribution(GoodsReq req);
}
