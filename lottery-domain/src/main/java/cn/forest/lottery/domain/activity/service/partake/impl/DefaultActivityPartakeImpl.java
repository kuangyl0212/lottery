package cn.forest.lottery.domain.activity.service.partake.impl;

import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.Result;
import cn.forest.lottery.domain.activity.service.partake.BaseActivityPartake;
import cn.hutool.Hutool;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Forest
 * @date 2023/3/15 15:22
 */
@Component
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

    @Override
    public void recordDrawOrder(Object buildDrawOrder) {

    }
}
