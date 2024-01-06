package com.examples.app.generating.code.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表字段
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-27 9:47
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableColumn {

}
