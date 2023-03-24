package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.domain.strategy.model.vo.DrawOrderVo;
import cn.forest.lottery.domain.strategy.repository.IUserStrategyExportRepository;
import cn.forest.lottery.infrastructure.dao.UserStrategyExportDao;
import cn.forest.lottery.infrastructure.po.UserStrategyExportPo;
import cn.forest.lottery.infrastructure.util.DataConverter;
import cn.forest.util.dbrouter.annotation.DBRouter;
import cn.forest.util.dbrouter.annotation.DbRouterStrategy;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 13:32
 */
@Repository
public class UserStrategyExportRepositoryImpl implements IUserStrategyExportRepository {
    @Resource
    UserStrategyExportDao userStrategyExportDao;

    @DBRouter(key = "uId")
    @DbRouterStrategy(splitTable = true)
    public boolean create(UserStrategyExportPo po) {
        return userStrategyExportDao.insert(po) == 1;
    }

    @Override
    public boolean saveDrawOrder(DrawOrderVo orderVo) {
        UserStrategyExportPo po = DataConverter.INSTANCE.toDo(orderVo);
        int cnt = userStrategyExportDao.insert(po);
        return cnt == 1;
    }
}
