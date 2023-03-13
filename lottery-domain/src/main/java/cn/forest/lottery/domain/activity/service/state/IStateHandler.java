package cn.forest.lottery.domain.activity.service.state;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.Result;

/**
 * @author Forest
 * @date 2023/3/13 13:49
 */
public interface IStateHandler {
    Result edit(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    Result commit(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    Result approve(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    Result deny(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    Result revoke(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    Result close(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
    Result open(Long activityId, Enum<LotteryConstants.ActivityState> currentState);
}
