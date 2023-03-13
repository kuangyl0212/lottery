package cn.forest.lottery.domain.activity.repository;

import cn.forest.lottery.common.LotteryConstants;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/13 17:14
 */
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    cn.forest.lottery.infrastructure.repository.ActivityRepository repository;

    @Override
    public boolean updateState(Long activityId, Enum<LotteryConstants.ActivityState> currentState, Enum<LotteryConstants.ActivityState> newState) {
        return repository.updateState(activityId, ((LotteryConstants.ActivityState) currentState).getCode(), ((LotteryConstants.ActivityState) newState).getCode());
    }
}
