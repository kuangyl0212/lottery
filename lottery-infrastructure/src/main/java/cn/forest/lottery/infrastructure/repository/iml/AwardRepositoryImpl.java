package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.Award;
import cn.forest.lottery.infrastructure.dao.AwardDao;
import cn.forest.lottery.infrastructure.repository.AwardRepository;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 奖品配置 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
@Component
public class AwardRepositoryImpl extends ServiceImpl<AwardDao, Award> implements AwardRepository {

}
