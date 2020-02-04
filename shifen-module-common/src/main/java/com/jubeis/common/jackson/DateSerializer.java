package com.jubeis.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * 用于处理日期序列化输出
 */
public class DateSerializer extends JsonSerializer<Object> {

    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        try {
            if (value != null) {
                LocalDateTime localDateTime=(LocalDateTime) value;
                jsonGenerator.writeNumber(Date.from(localDateTime.toInstant(ZoneOffset.of("+8"))).getTime());
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        serializers.defaultSerializeValue(value, jsonGenerator);
    }
}
