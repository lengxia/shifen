package com.jubeis.model.user.dos;

import com.jubeis.model.common.dos.DescriptiveDO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * 领域持久化对象
 *
 * @author duanlunbiao
 */
@Data
public class DomainDO extends DescriptiveDO {
    /**
     * 父id，最长32字符
     */
    private Long pid;
    /**
     * 领域名称，最长32字符，必需
     */
    private String name;

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
        DomainDO that = (DomainDO) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

}
