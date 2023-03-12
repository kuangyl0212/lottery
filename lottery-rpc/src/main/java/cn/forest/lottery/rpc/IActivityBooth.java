package cn.forest.lottery.rpc;

import cn.forest.lottery.rpc.req.ActivityReq;
import cn.forest.lottery.rpc.res.ActivityRes;

public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
