package cn.forest.lottery.domain.strategy.model;

import lombok.Data;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Data
public class DrawReq {
    Long strategyId;
    Long takeId;

    public DrawReq(Long strategyId, Long takeId) {
        this.strategyId = strategyId;
        this.takeId = takeId;
    }

    public DrawReq() {

    }
}
