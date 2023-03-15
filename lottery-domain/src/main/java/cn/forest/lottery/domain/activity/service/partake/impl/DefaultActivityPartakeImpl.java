package cn.forest.lottery.domain.activity.service.partake.impl;

import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.Result;
import cn.forest.lottery.domain.activity.service.partake.BaseActivityPartake;

/**
 * @author Forest
 * @date 2023/3/15 15:22
 */
public class DefaultActivityPartakeImpl extends BaseActivityPartake {
    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        return null;
    }

    @Override
    protected Result grabActivity(PartakeReq req, ActivityBillVO activityBillVO) {
        return null;
    }

    @Override
    protected Result checkActivityBill(PartakeReq req, ActivityBillVO activityBillVO) {
        return null;
    }
}
