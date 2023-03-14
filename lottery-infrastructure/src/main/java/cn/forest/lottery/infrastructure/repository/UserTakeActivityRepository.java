package cn.forest.lottery.infrastructure.repository;

import cn.forest.lottery.infrastructure.po.UserTakeActivity;
import cn.forest.util.dbrouter.annotation.DBRouter;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户参与活动记录表 服务类
 * </p>
 *
 * @author Forest
 * @since 2023-03-14
 */
public interface UserTakeActivityRepository extends IService<UserTakeActivity> {


    void create(UserTakeActivity userTakeActivity);

}
