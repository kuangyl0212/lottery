package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.repository.IActivityRepository;
import cn.forest.lottery.infrastructure.dao.ActivityDao;
import cn.forest.lottery.infrastructure.dao.UserTakeActivityCountDao;
import cn.forest.lottery.infrastructure.dao.UserTakeActivityDao;
import cn.forest.lottery.infrastructure.po.ActivityPo;
import cn.forest.lottery.infrastructure.po.UserTakeActivityCountPo;
import cn.forest.lottery.infrastructure.util.DataConverter;
import cn.forest.lottery.infrastructure.util.IncrDecrLambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 12:26
 */
@Repository
public class ActivityRepositoryImpl extends ServiceImpl<ActivityDao, ActivityPo> implements IActivityRepository {

    @Resource
    ActivityDao activityDao;

    @Resource
    UserTakeActivityDao userTakeActivityDao;

    @Resource
    UserTakeActivityCountDao userTakeActivityCountDao;

    @Override
    @Transactional
    public boolean updateState(Long activityId, Enum<LotteryConstants.ActivityState> currentState, Enum<LotteryConstants.ActivityState> newState) {
        ActivityPo activity = activityDao.selectOne(
                Wrappers.lambdaQuery(ActivityPo.class)
                        .eq(ActivityPo::getActivityId, activityId)
                        .eq(ActivityPo::getState, ((LotteryConstants.ActivityState)currentState).getCode())
                        .last(" for update"));
        if (activity == null) {
            return false;
        }
        activity.setState(((LotteryConstants.ActivityState)newState).getCode());
        return activityDao.updateById(activity) == 1;
    }

    @Override
    public ActivityBillVO queryActivityBill(Long activityId, String uId) {
        ActivityPo activityPo = queryByActivityId(activityId);
        UserTakeActivityCountPo activityCountPo = userTakeActivityCountDao.selectOne(Wrappers.lambdaQuery(UserTakeActivityCountPo.class)
                .eq(UserTakeActivityCountPo::getActivityId, activityId)
                .eq(UserTakeActivityCountPo::getUId, uId));
        ActivityBillVO res = DataConverter.INSTANCE.toVo(activityPo);
        res.setUId(uId);
        res.setUserTakeLeftCount(activityCountPo != null ? activityCountPo.getLeftCount(): null);
        return res;
    }

    @Override
    public void subtractActivityStock(Long activityId) {
        this.update(new IncrDecrLambdaUpdateWrapper<>(ActivityPo.class)
                .descField(ActivityPo::getStockSurplusCount, 1)
                .eq(ActivityPo::getActivityId, activityId));
    }

    private ActivityPo queryByActivityId(Long activityId) {
        return activityDao.selectOne(Wrappers.lambdaQuery(ActivityPo.class)
                .eq(ActivityPo::getActivityId, activityId));
    }
}
