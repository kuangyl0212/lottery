package cn.forest.lottery.domain.activity.service.state;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.common.Result;
import cn.forest.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/13 13:15
 */
public abstract class AbstractState {

    @Resource
    IActivityRepository activityRepository;

    public abstract Result edit(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    public abstract Result commit(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    public abstract Result approve(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    public abstract Result deny(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    public abstract Result revoke(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    public abstract Result close(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    public abstract Result open(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
}
