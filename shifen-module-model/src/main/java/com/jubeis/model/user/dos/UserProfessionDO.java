package com.jubeis.model.user.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jubeis.model.common.dos.BaseDO;
import com.jubeis.model.enums.SkillMajorProfessEnum;
import lombok.Data;

import java.util.Objects;

/**
 * 用户职业持久化对象
 *
 * @author yingming.yym
 */
@Data
public class UserProfessionDO extends BaseDO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 职业id
     */
    private Long professionId;
    /**
     * 用户职业等级
     */
    private String level;
    /**
     * 是否已经认证
     */
    @TableField("is_authentication")
    private Boolean authentication;
    /**
     * 认证图片
     */
    private String authImage;
    /**
     * 认证描述
     */
    private String authDescription;
    /**
     * 状态
     */
    private SkillMajorProfessEnum state;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserProfessionDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        UserProfessionDO that = (UserProfessionDO) o;
        return Objects.equals(userId, that.userId) && Objects.equals(professionId, that.professionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, professionId);
    }
}
