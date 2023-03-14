package cn.forest.lottery.infrastructure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */

@MapperScan("cn.forest.lottery.infrastructure.dao")
@SpringBootApplication
public class LotteryInfrastructureApplication {
    public static void main(String[] args) {
        SpringApplication.run(LotteryInfrastructureApplication.class, args);
    }

}
