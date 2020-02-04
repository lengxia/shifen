package com.jubeis.model.common.dos;

import lombok.Data;

import java.util.Objects;

/**
 * 具有描述字段的通用数据持久化对象
 *
 * @author shawn
 */
@Data
public abstract class DescriptiveDO extends BaseDO {
    /**
     * 描述字段，最长128字符
     */
    protected String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DescriptiveDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        DescriptiveDO that = (DescriptiveDO) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }
}
