package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.dao.UserTakeActivityDao;
import cn.forest.lottery.infrastructure.po.UserTakeActivityPo;
import cn.forest.util.dbrouter.annotation.DBRouter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 13:14
 */
@Repository
public class UserTakeActivityRepositoryImpl {
    @Resource
    UserTakeActivityDao userTakeActivityDao;

    @DBRouter(key = "uId")
    @Transactional
    public boolean create(UserTakeActivityPo userTakeActivityPo) {
        return userTakeActivityDao.insert(userTakeActivityPo) == 1;
    }
}
