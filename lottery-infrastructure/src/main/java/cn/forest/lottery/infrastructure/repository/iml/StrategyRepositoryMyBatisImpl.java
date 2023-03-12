package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.Strategy;
import cn.forest.lottery.infrastructure.dao.StrategyDao;
import cn.forest.lottery.infrastructure.po.StrategyDetail;
import cn.forest.lottery.infrastructure.repository.StrategyDetailRepository;
import cn.forest.lottery.infrastructure.repository.StrategyRepository;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 策略配置 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
@Component
public class StrategyRepositoryMyBatisImpl extends ServiceImpl<StrategyDao, Strategy> implements StrategyRepository {

    @Resource
    StrategyDetailRepository strategyDetailRepository;

    @Override
    public List<StrategyDetail> queryNonStockAwardIds(Long strategyId) {
        return strategyDetailRepository.list(Wrappers.lambdaQuery(StrategyDetail.class)
                .eq(StrategyDetail::getStrategyId, strategyId)
                .gt(StrategyDetail::getAwardSurplusCount, 0));
    }

    @Override
    public Strategy queryByStrategyId(Long strategyId) {
        return getOne(Wrappers.lambdaQuery(Strategy.class).eq(Strategy::getStrategyId, strategyId));
    }
}
