package com.jubeis.model.user.dos;

import com.jubeis.model.common.dos.DescriptiveDO;
import lombok.Data;

import java.util.Objects;

/**
 * 权限资源持久化对象
 *
 * @author shawn
 */
@Data
public class ResourceDO extends DescriptiveDO {

    /**
     * 资源名称，最长32字符，必需
     */
    private String name;

    /**
     * 资源url，最长256字符，唯一，必需
     */
    private String url;

    /**
     * 父资源id，外键
     */
    private Long pid;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResourceDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        ResourceDO that = (ResourceDO) o;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, url, pid);
    }
}
