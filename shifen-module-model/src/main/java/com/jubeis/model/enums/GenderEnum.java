package com.jubeis.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 性别枚举类
 *
 * @author shawn
 */
public enum GenderEnum implements IBaseEnum<Integer> {
    /**
     * 保密：0
     */
    SECRET(0, "保密"),
    /**
     * 男生：1
     */
    BOY(1, "男生"),
    /**
     * 女生：2
     */
    GIRL(2, "女生");

    private Integer value;
    private String desc;

    GenderEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    @JsonCreator
    public static GenderEnum of(Integer value) {
        return EnumValueParser.parse(value, GenderEnum.class);
    }

    @Override
    public String toString() {
        return "Gender{" + "value=" + value + ", desc='" + desc + '\'' + '}';
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
