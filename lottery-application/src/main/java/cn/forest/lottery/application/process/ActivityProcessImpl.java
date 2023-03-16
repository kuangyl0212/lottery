package cn.forest.lottery.application.process;

import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.PartakeResult;
import cn.forest.lottery.domain.activity.service.partake.IActivityPartake;
import cn.forest.lottery.domain.strategy.model.DrawAwardInfo;
import cn.forest.lottery.domain.strategy.model.DrawReq;
import cn.forest.lottery.domain.strategy.model.DrawResult;
import cn.forest.lottery.domain.strategy.service.draw.IDrawExec;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/16 10:03
 */
@Component
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    IActivityPartake activityPartake;

    @Resource
    IDrawExec drawExec;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {

        PartakeReq partakeReq = new PartakeReq();
        partakeReq.setActivityId(req.getActivityId());
        partakeReq.setUId(req.getUId());
        PartakeResult partakeRes = activityPartake.doPartake(partakeReq);

        Long strategyId = partakeRes.getStrategyId();
        Long takeId = partakeRes.getTakeId();

        DrawReq drawReq = new DrawReq(strategyId, takeId);

        DrawResult drawRes = drawExec.doDrawExec(drawReq);

        DrawAwardInfo drawAwardInfo = drawRes.getDrawAwardInfo();

        activityPartake.recordDrawOrder(buildDrawOrder(req, strategyId, takeId, drawAwardInfo));



        return null;
    }

    private Object buildDrawOrder(DrawProcessReq req, Long strategyId, Long takeId, DrawAwardInfo drawAwardInfo) {
        return null;
    }
}
