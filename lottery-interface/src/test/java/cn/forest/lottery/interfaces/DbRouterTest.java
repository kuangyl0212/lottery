package cn.forest.lottery.interfaces;

import cn.forest.lottery.infrastructure.po.UserStrategyExportPo;
import cn.forest.lottery.infrastructure.po.UserTakeActivityPo;
import cn.forest.lottery.infrastructure.repository.iml.UserStrategyExportRepositoryImpl;
import cn.forest.lottery.infrastructure.repository.iml.UserTakeActivityRepositoryImpl;
import cn.forest.util.dbrouter.DbRouterConfig;
import com.github.jsonzou.jmockdata.JMockData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 13:42
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryInterfaceApplication.class)
public class DbRouterTest {

    @Resource
    private DbRouterConfig dbRouterConfig;

    @Resource
    private UserTakeActivityRepositoryImpl userTakeActivityRepository;

    @Resource
    private UserStrategyExportRepositoryImpl userStrategyExportRepository;

    @Test
    void testDbRouter() {
        log.info(dbRouterConfig.toString());
        UserTakeActivityPo userTakeActivity;
        for (int i = 0; i < 100; i++) {
            userTakeActivity = JMockData.mock(UserTakeActivityPo.class);

            try {
                userTakeActivityRepository.create(userTakeActivity);
            } catch (Exception ignored) {

            }
        }

    }
    @Test
    void testDbRouterTable() {
        log.info(dbRouterConfig.toString());
        UserStrategyExportPo userStrategyExport;
        for (int i = 0; i < 100; i++) {
            userStrategyExport = JMockData.mock(UserStrategyExportPo.class);

            try {
                userStrategyExportRepository.create(userStrategyExport);
            } catch (Exception ignored) {

            }
        }

    }
}
