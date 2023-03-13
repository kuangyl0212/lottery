package cn.forest.lottery.infrastructure.repository;

import cn.forest.lottery.infrastructure.po.Award;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 奖品配置 服务类
 * </p>
 *
 * @author Forest
 * @since 2023-03-12
 */
public interface AwardRepository extends IService<Award> {

    Award queryByAwardId(Long awardId);
}
