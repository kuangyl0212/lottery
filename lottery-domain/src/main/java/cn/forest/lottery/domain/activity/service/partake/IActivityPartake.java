package cn.forest.lottery.domain.activity.service.partake;

import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.PartakeResult;
import cn.forest.lottery.domain.strategy.model.vo.DrawOrderVo;

/**
 * @author Forest
 * @date 2023/3/15 15:11
 */
public interface IActivityPartake {

    PartakeResult doPartake(PartakeReq partakeReq);


    boolean recordDrawOrder(DrawOrderVo orderVo);
}
