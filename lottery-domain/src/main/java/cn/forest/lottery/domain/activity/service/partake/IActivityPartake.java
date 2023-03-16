package cn.forest.lottery.domain.activity.service.partake;

import cn.forest.lottery.domain.activity.model.PartakeReq;
import cn.forest.lottery.domain.activity.model.PartakeResult;

/**
 * @author Forest
 * @date 2023/3/15 15:11
 */
public interface IActivityPartake {

    PartakeResult doPartake(PartakeReq partakeReq);


    void recordDrawOrder(Object buildDrawOrder);
}
