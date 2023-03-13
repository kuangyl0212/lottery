package cn.forest.lottery.domain.activity.service.state;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.Result;
import org.springframework.stereotype.Service;

/**
 * @author Forest
 * @date 2023/3/13 17:03
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    @Override
    public Result edit(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).edit(activityId, currentState);
    }

    @Override
    public Result commit(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).commit(activityId, currentState);
    }

    @Override
    public Result approve(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).approve(activityId, currentState);
    }

    @Override
    public Result deny(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).deny(activityId, currentState);
    }

    @Override
    public Result revoke(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).revoke(activityId, currentState);
    }

    @Override
    public Result close(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).close(activityId, currentState);
    }

    @Override
    public Result open(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return stateMap.get(currentState).open(activityId, currentState);
    }
}
