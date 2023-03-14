package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.Activity;
import cn.forest.lottery.infrastructure.dao.ActivityDao;
import cn.forest.lottery.infrastructure.repository.ActivityRepository;
import cn.forest.util.dbrouter.annotation.DBRouter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动配置 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
@Service
public class ActivityRepositoryImpl extends ServiceImpl<ActivityDao, Activity> implements ActivityRepository {

    @Override
    public boolean updateState(Long activityId, int currentState, int newState) {
        return this.update(Wrappers.lambdaUpdate(Activity.class)
                .eq(Activity::getActivityId, activityId).eq(Activity::getState, currentState)
                .set(Activity::getState, newState));
    }
}
