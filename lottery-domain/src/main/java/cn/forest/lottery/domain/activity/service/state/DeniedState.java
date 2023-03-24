package cn.forest.lottery.domain.activity.service.state;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.common.Result;
import org.springframework.stereotype.Component;

/**
 * @author Forest
 * @date 2023/3/13 13:54
 */
@Component
public class DeniedState extends AbstractState {
    @Override
    public Result edit(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.updateState(activityId, currentState, LotteryConstants.ActivityState.EDITING);
        return isSuccess ? new Result(0, "改为编辑状态成功") : new Result(1, "开启失败");
    }

    @Override
    public Result commit(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }

    @Override
    public Result approve(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }

    @Override
    public Result deny(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }

    @Override
    public Result revoke(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }

    @Override
    public Result close(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }

    @Override
    public Result open(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }
}
