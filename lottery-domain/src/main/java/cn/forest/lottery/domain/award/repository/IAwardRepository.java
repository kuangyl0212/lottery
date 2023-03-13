package cn.forest.lottery.domain.award.repository;

import cn.forest.lottery.infrastructure.po.Award;

/**
 * @author Forest
 * @date 2023/3/13 11:06
 */
public interface IAwardRepository {

    Award queryAwardByAwardId(Long awardId);

}
