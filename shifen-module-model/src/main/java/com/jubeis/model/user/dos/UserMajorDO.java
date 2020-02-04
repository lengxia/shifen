package com.jubeis.model.user.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jubeis.model.common.dos.DescriptiveDO;
import com.jubeis.model.enums.SkillMajorProfessEnum;
import lombok.Data;

import java.util.Objects;

/**
 * 用户专业持久化对象
 *
 * @author duanlunbiao
 */
@Data
public class UserMajorDO extends DescriptiveDO {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 专业id
     */
    private Long majorId;
    /**
     * 用户专业等级
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
        if (!(o instanceof UserMajorDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        UserMajorDO that = (UserMajorDO) o;
        return Objects.equals(userId, that.userId) && Objects.equals(majorId, that.majorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, majorId);
    }
}
