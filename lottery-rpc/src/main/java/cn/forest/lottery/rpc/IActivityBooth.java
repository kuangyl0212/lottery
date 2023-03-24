package cn.forest.lottery.rpc;

import cn.forest.lottery.rpc.req.DrawReq;
import cn.forest.lottery.rpc.res.DrawRes;

public interface IActivityBooth {
    DrawRes doDraw(DrawReq req);
}
