package cn.forest.lottery.domain.award.model;

import lombok.Data;

/**
 * @author Forest
 * @date 2023/3/13 11:08
 */
@Data
public class Award {
    private Long id;

    /**
     * 奖品ID
     */
    private Long awardId;

    /**
     * 奖品类型（文字描述、兑换码、优惠券、实物奖品暂无）
     */
    private Integer awardType;

    /**
     * 奖品数量
     */
    private Integer awardCount;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容「文字描述、Key、码」
     */
    private String awardContent;
}
