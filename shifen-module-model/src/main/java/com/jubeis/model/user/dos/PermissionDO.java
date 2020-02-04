package com.jubeis.model.user.dos;


import com.jubeis.model.common.dos.BaseDO;
import lombok.Data;

import java.util.Objects;

/**
 * 角色权限持久化数据对象
 *
 * <p>用于记录角色所拥有的的资源情况
 *
 * @author shawn
 */
@Data
public class PermissionDO extends BaseDO {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long resourceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        PermissionDO that = (PermissionDO) o;
        return roleId.equals(that.roleId) && resourceId.equals(that.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleId, resourceId);
    }
}
