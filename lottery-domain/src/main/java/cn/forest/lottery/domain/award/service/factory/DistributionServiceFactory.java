package cn.forest.lottery.domain.award.service.factory;

import cn.forest.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @author Forest
 * @date 2023/3/13 10:52
 */
@Service
public class DistributionServiceFactory extends DistributionServiceFactoryConfig {

    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return distributionServiceMap.get(awardType);
    }

}
