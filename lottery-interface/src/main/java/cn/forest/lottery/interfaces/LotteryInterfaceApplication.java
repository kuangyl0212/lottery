package cn.forest.lottery.interfaces;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@SpringBootApplication
@ComponentScan(basePackages = {"cn.forest.lottery.interfaces", "cn.forest.lottery.infrastructure", "cn.forest.lottery.domain"})
public class LotteryInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryInterfaceApplication.class, args);
    }
}
