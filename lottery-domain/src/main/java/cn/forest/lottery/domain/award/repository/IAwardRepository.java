package cn.forest.lottery.domain.award.repository;

import cn.forest.lottery.domain.award.model.Award;

/**
 * @author Forest
 * @date 2023/3/13 11:06
 */
public interface IAwardRepository {

    Award queryAwardByAwardId(Long awardId);

}
