package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.StrategyDetail;
import cn.forest.lottery.infrastructure.dao.StrategyDetailDao;
import cn.forest.lottery.infrastructure.repository.StrategyDetailRepository;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 策略明细 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
@Component
public class StrategyDetailRepositoryImpl extends ServiceImpl<StrategyDetailDao, StrategyDetail> implements StrategyDetailRepository {

    @Override
    public List<StrategyDetail> listByStrategyId(Long strategyId) {
        return list(Wrappers.lambdaQuery(StrategyDetail.class).eq(StrategyDetail::getStrategyId, strategyId));
    }
}
