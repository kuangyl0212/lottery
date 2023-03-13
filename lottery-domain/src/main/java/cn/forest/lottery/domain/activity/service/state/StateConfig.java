package cn.forest.lottery.domain.activity.service.state;

import cn.forest.lottery.common.LotteryConstants;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Forest
 * @date 2023/3/13 13:47
 */
public class StateConfig {

    @Resource
    EditingState editingState;
    @Resource
    CommittedState committedState;
    @Resource
    ApprovedState approvedState;
    @Resource
    DeniedState deniedState;
    @Resource
    OpenState openState;
    @Resource
    ClosedState closedState;

    protected Map<Enum<LotteryConstants.ActivityState>, AbstractState> stateMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        stateMap.put(LotteryConstants.ActivityState.EDITING, editingState);
        stateMap.put(LotteryConstants.ActivityState.APPROVED, approvedState);
        stateMap.put(LotteryConstants.ActivityState.COMMITTED, committedState);
        stateMap.put(LotteryConstants.ActivityState.DENIED, deniedState);
        stateMap.put(LotteryConstants.ActivityState.OPEN, openState);
        stateMap.put(LotteryConstants.ActivityState.CLOSED, closedState);
    }
}
