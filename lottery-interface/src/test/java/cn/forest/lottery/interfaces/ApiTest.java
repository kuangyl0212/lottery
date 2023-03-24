package cn.forest.lottery.interfaces;

import cn.forest.lottery.common.LotteryConstants;
import cn.forest.lottery.common.Result;
import cn.forest.lottery.domain.activity.repository.IActivityRepository;
import cn.forest.lottery.domain.activity.service.state.IStateHandler;
import cn.forest.lottery.domain.award.model.Award;
import cn.forest.lottery.domain.award.repository.IAwardRepository;
import cn.forest.lottery.domain.award.service.factory.DistributionServiceFactory;
import cn.forest.lottery.domain.award.service.goods.IDistributionGoods;
import cn.forest.lottery.domain.strategy.service.draw.IDrawExec;
import cn.forest.lottery.domain.strategy.model.DrawReq;
import cn.forest.lottery.domain.strategy.model.DrawResult;
import cn.forest.lottery.domain.support.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryInterfaceApplication.class)
class ApiTest {

    @Resource
    private IDrawExec drawExec;

    @Resource
    private DistributionServiceFactory distributionServiceFactory;

    private IAwardRepository awardRepository;
    @Resource
    private IAwardRepository awardRepository(IAwardRepository awardRepository) {
        return this.awardRepository = awardRepository;
    };

    @Resource
    private IActivityRepository activityRepository;

    @Resource
    private IStateHandler stateHandler;

    @Resource
    private Map<LotteryConstants.Ids, IIdGenerator> idGenerator;

    @org.junit.jupiter.api.Test
    void queryExcludeAwardsIds() {
        DrawReq req = new DrawReq();
        req.setStrategyId(10001L);
        log.info(drawExec.doDrawExec(req).toString());
    }

    @org.junit.jupiter.api.Test
    void testDistributionGoods() {
        DrawReq req = new DrawReq();
        req.setStrategyId(10001L);
        DrawResult res = drawExec.doDrawExec(req);
        log.info(res.toString());

        if (res.getAwardId() != null) {
            Long awardId = Long.valueOf(res.getAwardId());
            Award award = awardRepository.queryAwardByAwardId(awardId);
            IDistributionGoods distributionService = distributionServiceFactory.getDistributionGoodsService(award.getAwardType());
            distributionService.doDistribution(null);
        }

    }

    @Test
    void testUpdateActivityState() {

        Result res = stateHandler.close(100001L, LotteryConstants.ActivityState.OPEN);
        log.info(res.toString());
        Result res2 = stateHandler.open(100001L, LotteryConstants.ActivityState.CLOSED);
        log.info(res2.toString());
    }

    @Test
    void testIdGenerator() {
        log.info(String.valueOf(idGenerator.get(LotteryConstants.Ids.SnowFlake).nextId()));
        log.info(String.valueOf(idGenerator.get(LotteryConstants.Ids.ShortCode).nextId()));
        log.info(String.valueOf(idGenerator.get(LotteryConstants.Ids.RandomNumeric).nextId()));
    }

}