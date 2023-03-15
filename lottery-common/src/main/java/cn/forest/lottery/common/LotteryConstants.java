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
        CouponGoods(0),
        PhysicalGoods(1),
        Other(2),
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
    public enum Ids {
        /**
         * 雪花算法
         */
        SnowFlake(0),
        ShortCode(1),
        RandomNumeric(2),
        ;
        private final int code;

        Ids(int i) {
            code = i;
        }

        public int getCode() {
            return code;
        }
    }

    public enum ResponseCode {
        SUCCESS(0, "ok"),
        ;

        private final Integer code;
        private final String info;
        ResponseCode(int code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }


        public String getInfo() {
            return info;
        }
    }
}
