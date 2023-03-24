package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.forest.lottery.infrastructure.dao.UserTakeActivityDao;
import cn.forest.lottery.infrastructure.po.UserTakeActivityPo;
import cn.forest.util.dbrouter.annotation.DBRouter;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author Forest
 * @date 2023/3/15 13:14
 */
@Repository
public class UserTakeActivityRepositoryImpl extends ServiceImpl<UserTakeActivityDao, UserTakeActivityPo> implements IUserTakeActivityRepository {
    @Resource
    UserTakeActivityDao userTakeActivityDao;

    @DBRouter(key = "uId")
    @Transactional
    public boolean create(UserTakeActivityPo userTakeActivityPo) {
        return userTakeActivityDao.insert(userTakeActivityPo) == 1;
    }

    @Transactional
    @Override
    public boolean takeActivity(Long activityId, Long strategyId, Integer takeCount, Integer leftCount, String uId, LocalDateTime partakeDate, Long takeId) {
            UserTakeActivityPo po = new UserTakeActivityPo();
            po.setActivityId(activityId);
            po.setStrategyId(strategyId);
            if (leftCount == null) {
                po.setTakeCount(1);
            } else {
                po.setTakeCount(takeCount - leftCount + 1);
            }
            po.setUId(uId);
            po.setTakeDate(partakeDate);
            po.setState(LotteryConstants.TakeState.UNUSED.getCode());

            po.setUuid(uId + "_" + activityId + "_" + po.getTakeCount());
            po.setTakeId(takeId);

            return this.save(po);

    }
}
