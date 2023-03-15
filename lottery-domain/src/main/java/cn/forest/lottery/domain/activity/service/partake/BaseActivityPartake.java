package cn.forest.lottery.domain.activity.service.partake;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.PartakeResult;
import cn.forest.lottery.domain.activity.model.Result;

/**
 * @author Forest
 * @date 2023/3/15 15:13
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Override
    public PartakeResult doPartake(PartakeReq req) {
        // 查询活动账单
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        // 活动信息校验处理【活动库存、状态、日期、个人参与次数】
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!LotteryConstants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }

        // 扣减活动库存【目前为直接对配置库中的 lottery.activity 直接操作表扣减库存，后续优化为Redis扣减】
        Result subtractionActivityResult = this.subtractionActivityStock(req);
        if (!LotteryConstants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())) {
            return new PartakeResult(subtractionActivityResult.getCode(), subtractionActivityResult.getInfo());
        }

        // 领取活动信息【个人用户把活动信息写入到用户表】
        Result grabResult = this.grabActivity(req, activityBillVO);
        if (!LotteryConstants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }

        // 封装结果【返回的策略ID，用于继续完成抽奖步骤】
        PartakeResult partakeResult = new PartakeResult(LotteryConstants.ResponseCode.SUCCESS.getCode(), LotteryConstants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStrategyId());
        return partakeResult;
    }

    protected abstract Result subtractionActivityStock(PartakeReq req);

    protected abstract Result grabActivity(PartakeReq req, ActivityBillVO activityBillVO);

    protected abstract Result checkActivityBill(PartakeReq req, ActivityBillVO activityBillVO);
}
