package cn.forest.lottery.infrastructure;

import cn.forest.lottery.infrastructure.po.Strategy;
import cn.forest.lottery.infrastructure.repository.StrategyRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */

@RestController
@MapperScan("cn.forest.lottery.infrastructure.dao")
@SpringBootApplication
public class LotteryInfrastructureApplication {
    public static void main(String[] args) {
        SpringApplication.run(LotteryInfrastructureApplication.class, args);
    }

    @Resource
    StrategyRepository strategyRepository;

    @GetMapping("/strategy")
    public String getStrategy() {
        List<Strategy> res = strategyRepository.list();
        return res.toString();
    }
}
