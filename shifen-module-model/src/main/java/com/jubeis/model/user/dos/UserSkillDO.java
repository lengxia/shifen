package com.jubeis.model.user.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jubeis.model.common.dos.BaseDO;
import com.jubeis.model.enums.SkillMajorProfessEnum;
import lombok.Data;

import java.util.Objects;

/**
 * 用户技能持久化对象
 *
 * @author duanlunbiao
 */
@Data
public class UserSkillDO extends BaseDO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 技能id
     */
    private Long skillId;
    /**
     * 用户技能水平
     */
    private String level;
    @TableField("is_authentication")
    private Boolean authentication;
    /**
     * 认证图片路径
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
        if (!(o instanceof UserSkillDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        UserSkillDO that = (UserSkillDO) o;
        return Objects.equals(userId, that.userId) && Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, skillId);
    }

}
