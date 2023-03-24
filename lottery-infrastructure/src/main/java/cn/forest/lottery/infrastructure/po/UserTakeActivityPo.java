package cn.forest.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户参与活动记录表
 * </p>
 *
 * @author Forest
 * @since 2023-03-14
 */
@Getter
@Setter
@TableName("user_take_activity")
public class UserTakeActivityPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String uId;

    private Long takeId;

    private Long activityId;
    private Long strategyId;

    private String activityName;

    private LocalDateTime takeDate;

    private Integer takeCount;
    private Integer state;

    private String uuid;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
