package cn.forest.lottery.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Forest
 * @since 2023-03-15
 */
@Getter
@Setter
@TableName("rule_tree_node_line")
public class RuleTreeNodeLinePo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规则树ID
     */
    private Long treeId;

    /**
     * 节点From
     */
    private Long nodeIdFrom;

    /**
     * 节点To
     */
    private Long nodeIdTo;

    /**
     * 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围];7:果实
     */
    private Integer ruleLimitType;

    /**
     * 限定值
     */
    private String ruleLimitValue;


}
