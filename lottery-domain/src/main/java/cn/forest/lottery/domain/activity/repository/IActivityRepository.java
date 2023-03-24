package cn.forest.lottery.domain.activity.repository;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.ActivityBillVO;

/**
 * @author Forest
 * @date 2023/3/13 13:59
 */
public interface IActivityRepository {
    boolean updateState(Long activityId, Enum<LotteryConstants.ActivityState> currentState, Enum<LotteryConstants.ActivityState> newState);

    ActivityBillVO queryActivityBill(Long activityId, String uId);

    void subtractActivityStock(Long activityId);
}
