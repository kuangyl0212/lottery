package cn.forest.lottery.application.process;

/**
 * @author Forest
 * @date 2023/3/16 10:00
 */
public interface IActivityProcess {
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
