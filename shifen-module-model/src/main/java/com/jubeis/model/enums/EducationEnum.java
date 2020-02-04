package com.jubeis.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 学历枚举类
 *
 * <p>学历：1-小学，2-初中，3-中专，4-高职，5-高中，6-大学专科，7-大学本科，8-专业硕士研究生，9-学术硕士研究生，10-博士研究生，11-博士后
 *
 * @author shawn
 */
public enum EducationEnum implements IBaseEnum<Integer> {
    /**
     * 小学：1
     */
    PRIMARY_EDU(1, "小学"),
    /**
     * 初中：2
     */
    MIDDLE_EDU(2, "初中"),
    /**
     * 中专：3
     */
    VOCATIONAL_EDU(3, "职业中专"),
    /**
     * 高职：4
     */
    HIGHER_VOCATIONAL_EDU(4, "高职"),
    /**
     * 高中：5
     */
    HIGH_EDU(5, "高中"),
    /**
     * 大专：6
     */
    COLLEGE_EDU(6, "大学专科"),
    /**
     * 大学本科：7
     */
    UNIVERSITY_EDU(7, "大学本科"),
    /**
     * 专业硕士研究生：8
     */
    PROFESSIONAL_POST_GRADUATE_EDU(8, "专业硕士研究生"),
    /**
     * 学术硕士研究生：9
     */
    ACADEMIC_POST_GRADUATE_EDU(9, "学术硕士研究生"),
    /**
     * 博士研究生：10
     */
    DOCTORAL_CANDIDATE_EDU(10, "博士研究生"),
    /**
     * 博士后：11
     */
    POST_DOCTORAL_EDU(11, "博士后");

    private Integer value;
    private String desc;

    EducationEnum(Integer value, String desc) {
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
    public static EducationEnum of(Integer value) {
        return EnumValueParser.parse(value, EducationEnum.class);
    }
}
