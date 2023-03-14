package cn.forest.lottery.domain.support.ids.policy;

import cn.forest.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @description:
 * @author：Forest
 * @date: 2023/3/13
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String idStr = (year - 2023) +
                String.format("%02d", week) +
                day +
                hour +
                String.format("%03d", new Random().nextInt(1000));
        return Long.parseLong(idStr);
    }
}
