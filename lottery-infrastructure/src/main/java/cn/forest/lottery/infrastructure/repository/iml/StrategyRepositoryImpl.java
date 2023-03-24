package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.domain.award.model.Award;
import cn.forest.lottery.domain.strategy.model.StrategyAggregate;
import cn.forest.lottery.domain.strategy.model.StrategyDetail;
import cn.forest.lottery.domain.strategy.repository.IStrategyRepository;
import cn.forest.lottery.infrastructure.dao.AwardDao;
import cn.forest.lottery.infrastructure.dao.StrategyDao;
import cn.forest.lottery.infrastructure.dao.StrategyDetailDao;
import cn.forest.lottery.infrastructure.po.AwardPo;
import cn.forest.lottery.infrastructure.po.StrategyPo;
import cn.forest.lottery.infrastructure.po.StrategyDetailPo;
import cn.forest.lottery.infrastructure.util.DataConverter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Repository
public class StrategyRepositoryImpl implements IStrategyRepository {

    @Resource
    StrategyDao strategyDao;

    @Resource
    StrategyDetailDao strategyDetailDao;

    @Resource
    AwardDao awardDao;

    @Override
    public StrategyAggregate queryStrategyAggregateById(Long strategyId) {
        StrategyPo strategy = strategyDao.selectOne(Wrappers.lambdaQuery(StrategyPo.class)
                .eq(StrategyPo::getStrategyId, strategyId));
        List<StrategyDetailPo> strategyDetails = strategyDetailDao.selectList(Wrappers.lambdaQuery(StrategyDetailPo.class)
                .eq(StrategyDetailPo::getStrategyId, strategyId));
        return new StrategyAggregate(strategyId, DataConverter.INSTANCE.toDo(strategy), DataConverter.INSTANCE.toDo(strategyDetails));
    }

    @Override
    public Award queryAwardByAwardId(String awardId) {
        AwardPo po = awardDao.selectOne(
                Wrappers.lambdaQuery(AwardPo.class)
                        .eq(AwardPo::getAwardId, awardId));
        return DataConverter.INSTANCE.toDo(po);
    }

    @Override
    public List<StrategyDetail> queryNonStockAwardIds(Long strategyId) {
        List<StrategyDetailPo> pos = strategyDetailDao.selectList(Wrappers.lambdaQuery(StrategyDetailPo.class)
                .eq(StrategyDetailPo::getStrategyId, strategyId)
                .lt(StrategyDetailPo::getAwardSurplusCount, 0));
        return DataConverter.INSTANCE.toDo(pos);
    }

    @Override
    public boolean decreaseStock(Long strategyId, String awardId) {
        StrategyDetailPo strategyDetailPo = strategyDetailDao.selectOne(Wrappers.lambdaQuery(StrategyDetailPo.class)
                .eq(StrategyDetailPo::getStrategyId, strategyId)
                .eq(StrategyDetailPo::getAwardId, awardId)
                .last(" for update"));
        strategyDetailPo.setAwardSurplusCount(strategyDetailPo.getAwardSurplusCount() - 1);
        int cnt = strategyDetailDao.updateById(strategyDetailPo);
        return cnt == 1;
    }
}
