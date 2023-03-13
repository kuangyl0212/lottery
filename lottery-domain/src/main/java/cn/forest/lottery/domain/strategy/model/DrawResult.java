package cn.forest.lottery.domain.strategy.model;

import lombok.Data;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/12
 */
@Data
public class DrawResult {

    String awardId;

    DrawAwardInfo drawAwardInfo;
}
