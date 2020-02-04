package com.jubeis.model.user.dos;

import com.jubeis.model.common.dos.BaseDO;
import com.jubeis.model.enums.DegreeEnum;
import com.jubeis.model.enums.EducationEnum;
import com.jubeis.model.enums.GenderEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
public class UserInfoDO extends BaseDO {

    /**
     * 昵称，最长16字符
     */
    private String nickname;

    /**
     * 性别：0-保密，1-男生，2-女生，默认0
     */
    private GenderEnum gender;

    /**
     * 头像url，最长128字符
     */
    private String avatarUrl;

    /**
     * 真实姓名，最长32字符
     */
    private String realname;

    /**
     * 身份证号码，15字符或者18字符
     */
    private String idCardNo;

    /**
     * 是否已实名认证
     */
    private Boolean authenticated;

    /**
     * 个人简介，最长1024字符
     */
    private String introduction;

    /**
     * 出生年月日
     */
    private LocalDateTime birthdate;

    /**
     * 现居住地，最长128字符
     */
    private String address;

    /**
     * 家乡地址，最长128字符
     */
    private String homeAddress;

    /**
     * 社交网络地址，个人主页，最长128字符
     */
    private String socialUrl;

    /**
     * 毕业学校，最长32字符
     */
    private String school;

    /**
     * 单位名称，最长128字符
     */
    private String institution;

    /**
     * 学历：1-小学，2-初中，3-中专，4-高中，5-大学专科，6-大学本科，7-专业硕士研究生，8-学术硕士研究生，9-博士研究生，10-博士后
     */
    private EducationEnum education;

    /**
     * 学位：1-副学士，2-学士，3-硕士，4-博士，5-教授
     */
    private DegreeEnum degree;

    /**
     * 注册时设备所处ip地址，最长15字符
     */
    private String registerIp;

    /**
     * 注册时的定位，最长128字符
     */
    private String registerLocation;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserInfoDO)) {
            return false;
        }
        if (super.equals(o)) {
            return true;
        }
        UserInfoDO that = (UserInfoDO) o;
        return Objects.equals(realname, that.realname) && Objects.equals(idCardNo, that.idCardNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), realname, idCardNo);
    }
}
