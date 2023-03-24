package cn.forest.lottery.domain.activity.repository;

import java.time.LocalDateTime;

/**
 * @author Forest
 * @date 2023/3/22 15:05
 */
public interface IUserTakeActivityRepository {
    boolean takeActivity(Long activityId, Long strategyId, Integer takeCount, Integer leftCount, String uId, LocalDateTime partakeDate, Long takeId) throws Exception;
}
