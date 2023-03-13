package cn.forest.lottery.domain.strategy.service.draw;

import cn.forest.lottery.domain.strategy.model.DrawReq;
import cn.forest.lottery.domain.strategy.model.DrawResult;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
public interface IDrawExec {

    /**
     * 执行抽奖
     * @param req 抽奖请求
     * @return 抽奖结果
     */
    public DrawResult doDrawExec(DrawReq req);
}
