package cn.forest.lottery.domain.activity.model;

import cn.hutool.log.Log;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Forest
 * @date 2023/3/15 15:48
 */
@Data
public class ActivityBillVO {

    private Long id;

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 活动ID
     */
    private Long activityId;


    private Long strategyId;

    /**
     * 可领取次数
     */
    private Integer totalCount;

    private Integer stockSurplusCount;

    /**
     * 已领取次数
     */
    private Integer leftCount;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 开始时间
     */
    private LocalDateTime beginDateTime;

    /**
     * 结束时间
     */
    private LocalDateTime endDateTime;

    /**
     * 库存
     */
    private Integer stockCount;

    /**
     * 每人可参与次数
     */
    private Integer takeCount;

    /**
     * 活动状态：编辑、提审、撤审、通过、运行、拒绝、关闭、开启
     */
    private Integer state;


    private Integer userTakeLeftCount;


}
