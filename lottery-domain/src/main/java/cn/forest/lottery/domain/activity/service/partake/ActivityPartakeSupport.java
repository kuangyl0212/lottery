package cn.forest.lottery.domain.activity.service.partake;

import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.repository.IActivityRepository;
import cn.forest.lottery.domain.activity.repository.IUserTakeActivityCountRepository;
import cn.forest.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.forest.lottery.domain.strategy.repository.IUserStrategyExportRepository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 15:14
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    @Resource
    protected IUserTakeActivityRepository userTakeActivityRepository;

    @Resource
    protected IUserTakeActivityCountRepository userTakeActivityCountRepository;

    @Resource
    protected IUserStrategyExportRepository userStrategyExportRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req) {
        return activityRepository.queryActivityBill(req.getActivityId(), req.getUId());
    }
}
