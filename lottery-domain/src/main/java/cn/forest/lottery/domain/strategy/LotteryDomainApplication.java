package cn.forest.lottery.domain.strategy;

import cn.forest.lottery.domain.strategy.service.draw.IDrawExec;
import cn.forest.lottery.rpc.req.DrawReq;
import cn.forest.lottery.rpc.res.DrawResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */

@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"cn.forest.lottery.infrastructure", "cn.forest.lottery.domain"})
public class LotteryDomainApplication {
    public static void main(String[] args) {
        SpringApplication.run(LotteryDomainApplication.class, args);
    }

    @Resource
    private IDrawExec drawExec;

    @GetMapping("/draw")
    public DrawResult draw() {
        DrawReq req = new DrawReq();
        req.setStrategyId(1001L);
        return drawExec.doDrawExec(req);
    }
}
