package com.livarter.app.config;

import org.apache.ibatis.type.EnumTypeHandler;

/**
 * @author : 황수영
 * @fileName : MyEnumTypeHandler
 * @since : 2024-01-19
 * 내용 : Enum 타입을 String으로 DB에 저장하는 용도
 */
public class DatabaseEnumTypeHandler<E extends Enum<E>> extends EnumTypeHandler<E> {
    public DatabaseEnumTypeHandler(Class<E> type) {
        super(type);
    }
}