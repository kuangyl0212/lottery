package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.UserStrategyExport;
import cn.forest.lottery.infrastructure.dao.UserStrategyExportDao;
import cn.forest.lottery.infrastructure.repository.UserStrategyExportRepository;
import cn.forest.util.dbrouter.annotation.DBRouter;
import cn.forest.util.dbrouter.annotation.DbRouterStrategy;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户策略计算结果表 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-14
 */
@Service
public class UserStrategyExportRepositoryImpl extends ServiceImpl<UserStrategyExportDao, UserStrategyExport> implements UserStrategyExportRepository {

    @DBRouter(key = "uId")
    @DbRouterStrategy(splitTable = true)
    @Override
    public boolean create(UserStrategyExport userStrategyExport) {
        return save(userStrategyExport);
    }
}
