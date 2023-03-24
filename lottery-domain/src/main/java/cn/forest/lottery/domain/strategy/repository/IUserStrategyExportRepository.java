package cn.forest.lottery.domain.strategy.repository;

import cn.forest.lottery.domain.strategy.model.vo.DrawOrderVo;

/**
 * @author Forest
 * @date 2023/3/24 13:15
 */
public interface IUserStrategyExportRepository {
    boolean saveDrawOrder(DrawOrderVo orderVo);
}
