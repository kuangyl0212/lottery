package cn.forest.lottery.infrastructure.repository;

import cn.forest.lottery.infrastructure.po.Strategy;
import cn.forest.lottery.infrastructure.po.StrategyDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 策略配置 服务类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
public interface StrategyRepository extends IService<Strategy> {

    List<StrategyDetail> queryNonStockAwardIds(Long strategyId);

    Strategy queryByStrategyId(Long strategyId);
}
