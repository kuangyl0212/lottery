package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.infrastructure.po.Award;
import cn.forest.lottery.infrastructure.dao.AwardDao;
import cn.forest.lottery.infrastructure.repository.AwardRepository;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 奖品配置 服务实现类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
@Component
public class AwardRepositoryMybatisImpl extends ServiceImpl<AwardDao, Award> implements AwardRepository {

    @Override
    public Award queryByAwardId(Long awardId) {
        return getOne(Wrappers.lambdaQuery(Award.class).eq(Award::getAwardId, awardId));
    }
}
