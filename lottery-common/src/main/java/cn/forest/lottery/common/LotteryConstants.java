package cn.forest.lottery.common;

/**
 * @author Forest
 * @date 2023/3/13 10:44
 */
public class LotteryConstants {

    public enum AwardType {
        /**
         * 优惠券类型奖品
         */
        CouponGoods(2),
        PhysicalGoods(3),
        ;

        private final int code;

        AwardType(int i) {
            code = i;
        }


        public int getCode() {
            return code;
        }
    }

    public enum ActivityState {
        /**
         * 编辑中
         */
        EDITING(0),
        COMMITTED(1),
        APPROVED(2),
        DENIED(3),
        OPEN(4),
        CLOSED(5),
        ;

        private final int code;


        ActivityState(int i) {
            code = i;
        }

        public int getCode() {
            return code;
        }
    }
}
