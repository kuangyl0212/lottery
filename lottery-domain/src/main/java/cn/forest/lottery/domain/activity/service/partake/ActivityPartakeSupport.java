package cn.forest.lottery.domain.activity.service.partake;

import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 15:14
 */
public class ActivityPartakeSupport {

    @Resource
    IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req) {
        return activityRepository.queryActivityBill(req.getActivityId(), req.getUId());
    }
}
