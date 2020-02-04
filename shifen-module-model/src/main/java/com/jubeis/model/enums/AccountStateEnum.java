package com.jubeis.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 用户账户状态枚举类
 *
 * @author shawn
 */
public enum AccountStateEnum implements IBaseEnum<Integer> {
    /**
     * 正常：0
     */
    NORMAL(0, "正常"),
    /**
     * 被锁定：1
     */
    LOCKED(1, "被锁定"),
    /**
     * 被注销：2
     */
    CANCELLED(2, "被注销");

    private Integer value;
    private String desc;

    AccountStateEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    @JsonCreator
    public static AccountStateEnum of(Integer value) {
        return EnumValueParser.parse(value, AccountStateEnum.class);
    }

    @Override
    public String toString() {
        return "AccountState{" + "value=" + value + ", desc='" + desc + '\'' + '}';
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
