package com.jubeis.model.enums;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Optional;

/**
 * 通用枚举类型转换接口
 *
 * <p>可以用来作为枚举类型序列化和反序列化的公共接口类，实现此接口配合{@link com.fasterxml.jackson.annotation.JsonCreator}和{@link
 * com.fasterxml.jackson.annotation.JsonValue}即可实现。
 *
 * @author shawn
 */
public interface EnumValueParser<T> {

    /**
     * 获取枚举值
     *
     * @return 自定义枚举值
     */
    T getValue();

    /**
     * 通用的自定义枚举类型转换方法，凡是实现{@link EnumValueParser}接口的枚举类，并通过泛型指定枚举的值的类型， 即可通过此方法来将给定的值转换为对应的枚举类型。
     *
     * @param value 给定的值
     * @param clazz 要转换的枚举类的class类型
     * @param <T>   给定值的类型
     * @param <E>   要转换的枚举类
     * @return 转换后的枚举类型对象
     * @throws CustomEnumParseException 无法在给定枚举类型中找到对应枚举值或者给定值为{@code null}时，会抛出此异常
     */
    static <T, E extends Enum & EnumValueParser<T>> E parse(T value, Class<E> clazz)
            throws CustomEnumParseException {
        return Optional.ofNullable(value)
                .map(
                        val -> {
                            for (E item : clazz.getEnumConstants()) {
                                if (Objects.equals(item.getValue(), val)) {
                                    return item;
                                }
                            }
                            return null;
                        })
                .orElseThrow(
                        () ->
                                new CustomEnumParseException(
                                        MessageFormat.format(
                                                "Could not parse value {0} to type {1}.",
                                                value, clazz.getCanonicalName())));
    }

    class CustomEnumParseException extends RuntimeException {

        private static final long serialVersionUID = -2557475060594463395L;

        CustomEnumParseException(String message) {
            super(message);
        }

        CustomEnumParseException(String message, Throwable cause) {
            super(message, cause);
        }

        CustomEnumParseException(Throwable cause) {
            super(cause);
        }

        CustomEnumParseException(
                String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
