package cn.forest.lottery.interfaces;

import cn.forest.lottery.rpc.IActivityBooth;
import org.apache.dubbo.config.annotation.DubboService;
import cn.forest.lottery.rpc.req.ActivityReq;
import cn.forest.lottery.rpc.res.ActivityRes;

@DubboService
public class ActivityBooth implements IActivityBooth {
    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        ActivityRes res = new ActivityRes();
        res.setId(1000L);
        return res;
    }
}
