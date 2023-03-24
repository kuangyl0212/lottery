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
        /**
         *
         */
        SUCCESS(0, "ok"),
        NOT_START_OR_END(1, "活动没开始或已结束"),
        NO_STOCK(2, "活动无库存"),
        NO_LEFT_COUNT(3, "用户无剩余抽奖次数"),
        NOT_UPDATE(4, "扣取个人抽奖次数失败"),
        DUP_IDX(5, "唯一索引校验失败"),
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

    public enum TakeState {
        /**
         *
         */
        UNUSED(0),
        ;

        private final Integer code;

        TakeState(int i) {
            code = i;
        }


        public Integer getCode() {
            return code;
        }
    }
}
