package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.Activity;
import cn.forest.lottery.infrastructure.dao.ActivityDao;
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
public class ActivityRepositoryImpl extends ServiceImpl<ActivityDao, Activity> implements IService<Activity> {

}
