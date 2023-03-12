package cn.forest.lottery.infrastructure.repository;

import cn.forest.lottery.infrastructure.po.StrategyDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 策略明细 服务类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
public interface StrategyDetailRepository extends IService<StrategyDetail> {

    List<StrategyDetail> listByStrategyId(Long strategyId);
}
