package com.jubeis.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 学位枚举类
 *
 * <p>p>学位：1-副学士，2-学士，3-硕士，4-博士，5-教授
 *
 * @author shawn
 */
public enum DegreeEnum implements IBaseEnum<Integer> {
    /**
     * 副学士：1
     */
    ASSOCIATE_BACHELOR(1, "副学士"),
    /**
     * 学士：2
     */
    BACHELOR(2, "学士"),
    /**
     * 硕士：3
     */
    MASTER(3, "硕士"),
    /**
     * 博士：4
     */
    DOCTOR(4, "博士"),
    /**
     * 教授：5
     */
    PROFESSOR(5, "教授");

    private Integer value;
    private String desc;

    DegreeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return this.value;
    }

    @JsonCreator
    public static DegreeEnum of(Integer value) {
        return EnumValueParser.parse(value, DegreeEnum.class);
    }

    @Override
    public String toString() {
        return "DegreeEnum{" + "value=" + value + ", desc='" + desc + '\'' + '}';
    }
}
