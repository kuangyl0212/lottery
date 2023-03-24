package cn.forest.lottery.rpc.req;

import lombok.Data;

/**
 * @author Forest
 * @date 2023/3/24 13:44
 */
@Data
public class DrawReq {
    Long activityId;
    String uId;
}
