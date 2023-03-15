package cn.forest.lottery.interfaces;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@SpringBootApplication
@ComponentScan(basePackages = {"cn.forest.lottery"})
@MapperScan(basePackages = {"cn.forest.lottery.infrastructure.dao"})
public class LotteryInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryInterfaceApplication.class, args);
    }
}
