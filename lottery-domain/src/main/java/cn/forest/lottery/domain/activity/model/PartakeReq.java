package cn.forest.lottery.domain.activity.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Forest
 * @date 2023/3/15 15:13
 */
@Data
public class PartakeReq {
    Long activityId;
    String uId;
    LocalDateTime partakeDate;
}
