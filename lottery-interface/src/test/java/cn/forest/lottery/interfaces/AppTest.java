package cn.forest.lottery.interfaces;

import cn.forest.lottery.application.process.DrawProcessReq;
import cn.forest.lottery.application.process.DrawProcessResult;
import cn.forest.lottery.application.process.IActivityProcess;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/16 15:09
 */
@SpringBootTest(classes = LotteryInterfaceApplication.class)
@RunWith(SpringRunner.class)
public class AppTest {
    @Resource
    IActivityProcess activityProcess;

    @Test
    void testActivityProcess() {
        DrawProcessReq req = new DrawProcessReq();
        req.setActivityId(100001L);
        req.setUId("Uhdgkw766120d");
        DrawProcessResult res = activityProcess.doDrawProcess(req);
    }
}
