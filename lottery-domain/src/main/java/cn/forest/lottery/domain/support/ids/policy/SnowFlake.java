package cn.forest.lottery.domain.support.ids.policy;

import cn.forest.lottery.domain.support.ids.IIdGenerator;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/13
 */
@Component
public class SnowFlake implements IIdGenerator {
    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
        workerId = workerId >> 16 & 31;

        long dataCenterId = 1L;
        snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
    }
    @Override
    public long nextId() {
        return snowflake.nextId();
    }
}
