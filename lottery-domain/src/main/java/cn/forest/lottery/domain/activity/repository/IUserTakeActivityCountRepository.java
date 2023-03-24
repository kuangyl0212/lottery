package cn.forest.lottery.domain.activity.repository;

/**
 * @author Forest
 * @date 2023/3/22 15:13
 */
public interface IUserTakeActivityCountRepository {
    boolean subtractLeftCount(Long activityId, Integer takeCount, Integer leftCount, String uId);
}
