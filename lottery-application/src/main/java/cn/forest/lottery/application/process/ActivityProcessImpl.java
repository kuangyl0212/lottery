package cn.forest.lottery.application.process;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.PartakeResult;
import cn.forest.lottery.domain.activity.service.partake.IActivityPartake;
import cn.forest.lottery.domain.strategy.model.AwardInfo;
import cn.forest.lottery.domain.strategy.model.DrawReq;
import cn.forest.lottery.domain.strategy.model.DrawResult;
import cn.forest.lottery.domain.strategy.model.vo.DrawOrderVo;
import cn.forest.lottery.domain.strategy.service.draw.IDrawExec;
import cn.forest.lottery.domain.support.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Forest
 * @date 2023/3/16 10:03
 */
@Slf4j
@Component
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    IActivityPartake activityPartake;

    @Resource
    IDrawExec drawExec;

    @Resource
    private Map<LotteryConstants.Ids, IIdGenerator> idGenerator;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {

        PartakeReq partakeReq = new PartakeReq();
        partakeReq.setActivityId(req.getActivityId());
        partakeReq.setUId(req.getUId());
        PartakeResult partakeRes = activityPartake.doPartake(partakeReq);

        log.info("活动参与结果: {}", partakeRes.toString());

        if (partakeRes.getCode().equals(LotteryConstants.ResponseCode.SUCCESS.getCode())) {
            log.info("开始抽奖");
            Long strategyId = partakeRes.getStrategyId();
            Long takeId = partakeRes.getTakeId();

            DrawReq drawReq = new DrawReq(strategyId, takeId);

            DrawResult drawRes = drawExec.doDrawExec(drawReq);

            AwardInfo drawAwardInfo = drawRes.getDrawAwardInfo();
            log.info("抽奖结束：{}", drawRes);

            activityPartake.recordDrawOrder(buildDrawOrder(req, strategyId, takeId, drawAwardInfo));
        }





        return null;
    }

    private DrawOrderVo buildDrawOrder(DrawProcessReq req, Long strategyId, Long takeId, AwardInfo drawAwardInfo) {

        return DrawOrderVo.builder()
                .orderId(idGenerator.get(LotteryConstants.Ids.SnowFlake).nextId())
                .activityId(req.getActivityId())
                .uId(req.getUId())
                .takeId(takeId)
                .strategyId(strategyId)
                .strategyMode(drawAwardInfo.getStrategyMode())
                .awardId(drawAwardInfo.getAwardId())
                .grantDate(drawAwardInfo.getGrantDate())
                .awardName(drawAwardInfo.getAwardName())
                .awardContent(drawAwardInfo.getAwardContent())
                .grantType(drawAwardInfo.getGrantType())

                .build();
    }
}
