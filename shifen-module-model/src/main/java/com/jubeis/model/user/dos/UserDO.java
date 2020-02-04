package com.jubeis.model.user.dos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jubeis.model.common.dos.BaseDO;
import com.jubeis.model.enums.AccountStateEnum;
import lombok.Data;

import java.util.Objects;

/**
 * 用户登录注册信息持久化对象
 *
 * @author shawn
 */
@Data
@TableName("user")
public class UserDO extends BaseDO {

    /**
     * 用户名，最长32字符，必需
     */
    private String username;

    /**
     * 绑定手机号，13位，前面加国家地区代码（86）
     */
    private String phone;

    /**
     *
     */
    private String email;

    /**
     * md5加密密码，定长32位
     */
    private String password;

    /**
     * 密码盐，固定长度4位
     */
    private String salt;

    /**
     * 是否在线
     */
    @TableField("is_logged")
    private Boolean logged;

    /**
     * 账户状态：0-正常（normal），1-被锁定（locked），2-被注销（cancelled）
     */
    private AccountStateEnum state;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        UserDO userPO = (UserDO) o;
        return username.equals(userPO.username)
                || Objects.equals(phone, userPO.phone)
                || Objects.equals(email, userPO.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, phone, email);
    }
}
