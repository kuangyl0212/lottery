package cn.forest.lottery.domain.award.repository.impl;

import cn.forest.lottery.domain.award.repository.IAwardRepository;
import cn.forest.lottery.infrastructure.po.Award;
import cn.forest.lottery.infrastructure.repository.AwardRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Forest
 * @date 2023/3/13 11:18
 */

@Repository
public class AwardRepositoryImpl implements IAwardRepository {

    @Resource
    AwardRepository awardRepository;

    @Override
    public Award queryAwardByAwardId(Long awardId) {
        return awardRepository.queryByAwardId(awardId);
    }
}
