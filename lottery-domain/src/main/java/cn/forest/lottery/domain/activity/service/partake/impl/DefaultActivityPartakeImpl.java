package cn.forest.lottery.domain.activity.service.partake.impl;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.common.Result;
import cn.forest.lottery.domain.activity.service.partake.BaseActivityPartake;
import cn.forest.lottery.domain.strategy.model.vo.DrawOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;

/**
 * @author Forest
 * @date 2023/3/15 15:22
 */
@Slf4j
@Component
public class DefaultActivityPartakeImpl extends BaseActivityPartake {
    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        this.activityRepository.subtractActivityStock(req.getActivityId());
        return new Result(LotteryConstants.ResponseCode.SUCCESS.getCode(), LotteryConstants.ResponseCode.SUCCESS.getInfo());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    protected Result grabActivity(PartakeReq req, ActivityBillVO bill, Long takeId) {
        boolean subtractRes = this.userTakeActivityCountRepository.subtractLeftCount(bill.getActivityId(), bill.getTakeCount(), bill.getUserTakeLeftCount(), req.getUId());

        if (!subtractRes) {
            log.info("参加活动失败：扣减个人抽奖次数不成功");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new Result(LotteryConstants.ResponseCode.NOT_UPDATE.getCode(), LotteryConstants.ResponseCode.NOT_UPDATE.getInfo());
        }

        try {
            this.userTakeActivityRepository.takeActivity(
                    bill.getActivityId(),
                    bill.getStrategyId(),
                    bill.getTakeCount(),
                    bill.getUserTakeLeftCount(),
                    req.getUId(),
                    req.getPartakeDate(),
                    takeId);
        } catch (Exception e) {

            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("参加活动失败：添加参与记录不成功");
            return new Result(LotteryConstants.ResponseCode.DUP_IDX.getCode(), LotteryConstants.ResponseCode.DUP_IDX.getInfo());

        }


        return new Result(LotteryConstants.ResponseCode.SUCCESS.getCode(), LotteryConstants.ResponseCode.SUCCESS.getInfo());
    }

    @Override
    protected Result checkActivityBill(PartakeReq req, ActivityBillVO activityBillVO) {
        LocalDateTime now = LocalDateTime.now();
        Result res = new Result();
        if (activityBillVO.getBeginDateTime().isAfter(now) || activityBillVO.getEndDateTime().isBefore(now) ) {
            res.setCode(LotteryConstants.ResponseCode.NOT_START_OR_END.getCode());
            res.setInfo(LotteryConstants.ResponseCode.NOT_START_OR_END.getInfo());
            return res;
        }
        if (activityBillVO.getStockSurplusCount() <= 0) {

            res.setCode(LotteryConstants.ResponseCode.NO_STOCK.getCode());
            res.setInfo(LotteryConstants.ResponseCode.NO_STOCK.getInfo());
            return res;
        }
        if (activityBillVO.getUserTakeLeftCount() != null && activityBillVO.getUserTakeLeftCount() <= 0) {
            res.setCode(LotteryConstants.ResponseCode.NO_LEFT_COUNT.getCode());
            res.setInfo(LotteryConstants.ResponseCode.NO_LEFT_COUNT.getInfo());
            return res;
        }
        res.setCode(LotteryConstants.ResponseCode.SUCCESS.getCode());
        res.setInfo(LotteryConstants.ResponseCode.SUCCESS.getInfo());
        return res;
    }

    @Override
    public boolean recordDrawOrder(DrawOrderVo orderVo) {
        return this.userStrategyExportRepository.saveDrawOrder(orderVo);
    }
}
