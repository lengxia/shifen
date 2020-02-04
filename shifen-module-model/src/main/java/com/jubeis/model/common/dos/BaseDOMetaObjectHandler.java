package com.jubeis.model.common.dos;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Component
public class BaseDOMetaObjectHandler implements MetaObjectHandler {

    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("Asia/Shanghai");

    @Override
    public void insertFill(MetaObject metaObject) {
        String[] fieldNames = {"gmtCreate", "gmtModified"};
        LocalDateTime now = LocalDateTime.now(DEFAULT_ZONE_ID);
        for (String fieldName : fieldNames) {
            log.debug("Auto insert fill '{}'='{}'.", fieldName, now);
            this.strictInsertFill(metaObject, fieldName, LocalDateTime.class, now);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime now = LocalDateTime.now(DEFAULT_ZONE_ID);
        String fieldName = "gmtModified";
        log.debug("Auto update fill '{}'='{}'.", fieldName, now);
        this.strictUpdateFill(metaObject, fieldName, LocalDateTime.class, now);
    }
}
