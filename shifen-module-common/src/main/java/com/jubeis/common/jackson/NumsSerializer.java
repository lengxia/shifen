package com.jubeis.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jubeis.utils.common.IdsUtils;

import java.io.IOException;

/**
 * 用于序列化自增数字的混淆
 */
public class NumsSerializer extends JsonSerializer<Object> {

    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        try {
            if (value != null) {
                jsonGenerator.writeString(IdsUtils.encryptNumber(Long.valueOf(value.toString())));
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        serializers.defaultSerializeValue(value, jsonGenerator);
    }
}