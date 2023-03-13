package cn.forest.lottery.domain.activity.service.state;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.Result;
import org.springframework.stereotype.Component;

/**
 * @author Forest
 * @date 2023/3/13 13:44
 */
@Component
public class EditingState extends AbstractState {
    @Override
    public Result edit(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        return new Result(1, "不允许修改");
    }

    @Override
    public Result commit(Long activityId, Enum<LotteryConstants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.updateState(activityId, currentState, LotteryConstants.ActivityState.COMMITTED);
        return isSuccess ? new Result(0, "撤销审核成功") : new Result(1, "撤销失败");
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
