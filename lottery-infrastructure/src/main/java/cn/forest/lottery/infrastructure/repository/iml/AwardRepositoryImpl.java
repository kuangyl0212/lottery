package cn.forest.lottery.infrastructure.repository.iml;

import cn.forest.lottery.domain.award.model.Award;
import cn.forest.lottery.domain.award.repository.IAwardRepository;
import cn.forest.lottery.infrastructure.dao.AwardDao;
import cn.forest.lottery.infrastructure.po.AwardPo;
import cn.forest.lottery.infrastructure.util.DataConverter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/15 12:33
 */
@Repository
public class AwardRepositoryImpl implements IAwardRepository {

    @Resource
    AwardDao awardDao;

    @Override
    public Award queryAwardByAwardId(Long awardId) {
        AwardPo po = awardDao.selectOne(
                Wrappers.lambdaQuery(AwardPo.class)
                        .eq(AwardPo::getAwardId, awardId));

        return DataConverter.INSTANCE.toDo(po);
    }
}
