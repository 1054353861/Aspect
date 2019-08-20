package com.android.aspectj.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lucas
 *
 * @description 自定义注解
 */
public interface LogTraceAspectInterface {

    @Retention(RetentionPolicy.CLASS)
    @Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
    public @interface Debug {
    }
}
