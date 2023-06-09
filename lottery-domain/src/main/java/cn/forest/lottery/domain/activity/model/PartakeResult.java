package cn.forest.lottery.domain.activity.model;

import lombok.Data;

/**
 * @author Forest
 * @date 2023/3/15 15:13
 */
@Data
public class PartakeResult {
    Long strategyId;
    Long takeId;
    Integer code;
    String info;

    public PartakeResult(Integer code, String info) {
        this.code = code;
        this.info = info;
    }
}
