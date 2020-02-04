package com.jubeis.model.user.dos;

import com.jubeis.model.common.dos.DescriptiveDO;
import lombok.Data;

import java.util.Objects;

/**
 * 用户角色持久化对象
 *
 * @author shawn
 */
@Data
public class RoleDO extends DescriptiveDO {

    /**
     * 角色名称，最长32字符，必需
     */
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RoleDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        RoleDO rolePO = (RoleDO) o;
        return name.equals(rolePO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
