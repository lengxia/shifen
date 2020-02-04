package com.jubeis.model.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;
/**
 * 通用枚举接口
 *
 * <p>继承了自定义枚举接口{@link EnumValueParser}，可以用于Json序列化与反序列化； 还继承了{@link
 * IEnum}，可以用于mybatis自动映射DO对象枚举字段的值到数据库表字段
 *
 * @author shawn
 */
public interface IBaseEnum<T extends Serializable> extends IEnum<T>, EnumValueParser<T> {

    /**
     * 获取描述
     *
     * @return 描述
     */
    String getDesc();
}
