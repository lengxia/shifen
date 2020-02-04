package com.jubeis.model.user.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.jubeis.model.common.dos.DescriptiveDO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * 职业持久化对象
 *
 * @author duanlunbiao
 */
@Data
public class ProfessionDO extends DescriptiveDO {
    /**
     * 父id，最长32字符
     */
    private Long pid;

    /**
     * 从属于职业id
     */
    private Long domainId;
    /**
     * 领域名称，最长32字符，必需
     */
    private String name;

    @TableField("is_required_authentication")
    private Boolean authentication;

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
        ProfessionDO that = (ProfessionDO) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

}
