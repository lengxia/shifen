package com.jubeis.model.common.dos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 数据持久化对象统一风格公共抽象模型
 *
 * <p>任何对应关系型数据库表的持久化对象都要继承自此类。
 *
 * @author shawn
 */
@Data
public abstract class BaseDO {

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    protected Long id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime gmtModified;

    /**
     * 获取id字段，可能是逻辑id或者含有具体业务实际含义的id
     *
     * @return the id of the persistent object.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseDO baseDO = (BaseDO) o;
        return id.equals(baseDO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
