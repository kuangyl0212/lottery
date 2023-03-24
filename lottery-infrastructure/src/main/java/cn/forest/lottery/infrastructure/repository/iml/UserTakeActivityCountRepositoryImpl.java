package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.domain.activity.repository.IUserTakeActivityCountRepository;
import cn.forest.lottery.infrastructure.dao.UserTakeActivityCountDao;
import cn.forest.lottery.infrastructure.po.UserTakeActivityCountPo;
import cn.forest.lottery.infrastructure.util.IncrDecrLambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Forest
 * @date 2023/3/22 15:56
 */
@Repository
public class UserTakeActivityCountRepositoryImpl extends ServiceImpl<UserTakeActivityCountDao, UserTakeActivityCountPo> implements IUserTakeActivityCountRepository {
    @Override
    @Transactional
    public boolean subtractLeftCount(Long activityId, Integer takeCount, Integer leftCount, String uId) {
        if (leftCount == null) {
            UserTakeActivityCountPo po = new UserTakeActivityCountPo();
            po.setActivityId(activityId);
            po.setUId(uId);
            po.setTotalCount(takeCount);
            po.setLeftCount(takeCount - 1);
            return this.save(po);
        } else {
            return this.update(new IncrDecrLambdaUpdateWrapper<>(UserTakeActivityCountPo.class)
                    .descField(UserTakeActivityCountPo::getLeftCount, 1)
                    .eq(UserTakeActivityCountPo::getActivityId, activityId)
                    .eq(UserTakeActivityCountPo::getUId, uId));
        }
    }
}
