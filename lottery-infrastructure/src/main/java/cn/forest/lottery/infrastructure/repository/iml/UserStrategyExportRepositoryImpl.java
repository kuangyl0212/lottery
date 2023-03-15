package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.dao.UserStrategyExportDao;
import cn.forest.lottery.infrastructure.po.UserStrategyExportPo;
import cn.forest.util.dbrouter.annotation.DBRouter;
import cn.forest.util.dbrouter.annotation.DbRouterStrategy;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 13:32
 */
@Repository
public class UserStrategyExportRepositoryImpl {
    @Resource
    UserStrategyExportDao userStrategyExportDao;

    @DBRouter(key = "uId")
    @DbRouterStrategy(splitTable = true)
    public boolean create(UserStrategyExportPo po) {
        return userStrategyExportDao.insert(po) == 1;
    }
}
