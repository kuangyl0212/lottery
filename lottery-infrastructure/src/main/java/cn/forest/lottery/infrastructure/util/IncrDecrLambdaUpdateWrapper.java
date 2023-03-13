package cn.forest.lottery.infrastructure.util;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * @author Forest
 * @date 2023/3/13 12:00
 */
public class IncrDecrLambdaUpdateWrapper<T> extends LambdaUpdateWrapper<T> {
    public IncrDecrLambdaUpdateWrapper(Class<T> entityClass) {
        super(entityClass);
    }

    /**
     * 指定列自增
     * @param columns           列引用
     * @param value             增长值
     */
    public IncrDecrLambdaUpdateWrapper<T> incrField(SFunction<T, ?> columns, Object value) {
        String columnsToString = super.columnToString(columns);


        String format = String.format("%s =  %s + %s", columnsToString,columnsToString, value);

        setSql(format);

        return this;
    }

    /**
     * 指定列自减
     * @param columns           列引用
     * @param value             减少值
     */
    public IncrDecrLambdaUpdateWrapper<T> descField(SFunction<T, ?> columns, Object value) {
        String columnsToString = super.columnToString(columns);

        String format = String.format("%s =  %s - %s", columnsToString,columnsToString, value);

        setSql(format);

        return this;
    }
}
