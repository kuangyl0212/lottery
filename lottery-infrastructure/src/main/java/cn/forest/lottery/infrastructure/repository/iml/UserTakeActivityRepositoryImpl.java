package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.UserTakeActivity;
import cn.forest.lottery.infrastructure.dao.UserTakeActivityDao;
import cn.forest.lottery.infrastructure.repository.UserTakeActivityRepository;
import cn.forest.util.dbrouter.annotation.DBRouter;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户参与活动记录表 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-14
 */
@Service
public class UserTakeActivityRepositoryImpl extends ServiceImpl<UserTakeActivityDao, UserTakeActivity> implements UserTakeActivityRepository {

    @DBRouter(key = "uId")
    @Override
    public void create(UserTakeActivity userTakeActivity) {
        save(userTakeActivity);
    }
}
