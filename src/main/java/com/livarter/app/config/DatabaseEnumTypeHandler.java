package com.livarter.app.config;

import org.apache.ibatis.type.EnumTypeHandler;

/**
 * @author : 황수영
 * @fileName : MyEnumTypeHandler
 * @since : 2024-01-19
 */
public class DatabaseEnumTypeHandler<E extends Enum<E>> extends EnumTypeHandler<E> {
    public DatabaseEnumTypeHandler(Class<E> type) {
        super(type);
    }
}