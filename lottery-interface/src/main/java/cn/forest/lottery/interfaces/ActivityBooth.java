package cn.forest.lottery.interfaces;

import cn.forest.lottery.application.process.DrawProcessReq;
import cn.forest.lottery.application.process.DrawProcessResult;
import cn.forest.lottery.application.process.IActivityProcess;
import cn.forest.lottery.rpc.IActivityBooth;
import cn.forest.lottery.rpc.req.DrawReq;
import cn.forest.lottery.rpc.res.DrawRes;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class ActivityBooth implements IActivityBooth {

    @Resource
    IActivityProcess activityProcess;


    @Override
    public DrawRes doDraw(DrawReq req) {
        DrawProcessReq drawProcessReq = new DrawProcessReq();
        DrawProcessResult appRes = activityProcess.doDrawProcess(drawProcessReq);
        return DrawRes.builder().build();
    }
}
