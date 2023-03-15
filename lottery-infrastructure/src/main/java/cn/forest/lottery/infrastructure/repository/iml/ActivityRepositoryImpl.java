package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.repository.IActivityRepository;
import cn.forest.lottery.infrastructure.dao.ActivityDao;
import cn.forest.lottery.infrastructure.po.ActivityPo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 12:26
 */
@Repository
public class ActivityRepositoryImpl implements IActivityRepository {

    @Resource
    ActivityDao activityDao;

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
}
