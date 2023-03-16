package cn.forest.lottery.infrastructure.util;

import cn.forest.lottery.domain.activity.model.ActivityBillVO;
import cn.forest.lottery.domain.strategy.model.Strategy;
import cn.forest.lottery.domain.strategy.model.StrategyDetail;
import cn.forest.lottery.domain.award.model.Award;
import cn.forest.lottery.infrastructure.po.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Forest
 * @date 2023/3/15 10:29
 */
@Mapper
public interface DataConverter {
    DataConverter INSTANCE = Mappers.getMapper(DataConverter.class);

    Strategy toDo(StrategyPo po);
    StrategyDetail toDo(StrategyDetailPo po);

    List<StrategyDetail> toDo(List<StrategyDetailPo> strategyDetails);

    Award toDo(AwardPo po);

    ActivityBillVO toVo(UserTakeActivityCountPo po);

    ActivityBillVO toVo(ActivityPo activityPo);
}
