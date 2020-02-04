package com.jubeis.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 技能专业职业用户认证状态枚举类
 *
 * @author duanlunbiao
 */
public enum SkillMajorProfessEnum implements IBaseEnum<Integer> {

    UNSUBMIT(0, "未提交"),
    SUBMIT(1, "已提交"),
    NOT_PASS(2, "审核不通过"),
    PASS(3, "审核通过");


    private Integer value;
    private String desc;

    SkillMajorProfessEnum(Integer value, String desc) {
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
    public static SkillMajorProfessEnum of(Integer value) {
        return EnumValueParser.parse(value, SkillMajorProfessEnum.class);
    }
}
