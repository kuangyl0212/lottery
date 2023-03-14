package cn.forest.lottery.domain.support.ids;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/13
 */
public interface IIdGenerator {
    /**
     * 获取唯一ID
     * @return ID
     */
    long nextId();
}
