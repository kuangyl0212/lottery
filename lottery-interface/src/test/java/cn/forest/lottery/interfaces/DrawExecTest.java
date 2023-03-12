package cn.forest.lottery.interfaces;

import cn.forest.lottery.domain.strategy.service.draw.IDrawExec;
import cn.forest.lottery.rpc.req.DrawReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryInterfaceApplication.class)
class DrawExecTest {

    @Resource
    private IDrawExec drawExec;

    @org.junit.jupiter.api.Test
    void queryExcludeAwardsIds() {
        DrawReq req = new DrawReq();
        req.setStrategyId(1001L);
        log.info(drawExec.doDrawExec(req).toString());
    }
}