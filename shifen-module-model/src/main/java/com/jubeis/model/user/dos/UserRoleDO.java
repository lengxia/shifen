package com.jubeis.model.user.dos;

import com.jubeis.model.common.dos.BaseDO;
import lombok.Data;
import java.util.Objects;

@Data
public class UserRoleDO extends BaseDO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserRoleDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        UserRoleDO that = (UserRoleDO) o;
        return userId.equals(that.userId) && roleId.equals(that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, roleId);
    }
}
