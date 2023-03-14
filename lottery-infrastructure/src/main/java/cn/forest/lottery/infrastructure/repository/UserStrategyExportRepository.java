package cn.forest.lottery.infrastructure.repository;

import cn.forest.lottery.infrastructure.po.UserStrategyExport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户策略计算结果表 服务类
 * </p>
 *
 * @author Forest
 * @since 2023-03-14
 */
public interface UserStrategyExportRepository extends IService<UserStrategyExport> {

    boolean create(UserStrategyExport userStrategyExport);

}
