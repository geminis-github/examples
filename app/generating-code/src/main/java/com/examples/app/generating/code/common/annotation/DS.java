package com.examples.app.generating.code.common.annotation;

import com.examples.app.generating.code.common.enums.DataSourceType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义多数据源切换注解
 * 优先级：先方法，后类，如果方法覆盖了类上的数据源类型，以方法的为准，否则以类上的为准
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-28 10:31
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DS
{
    /**
     * 切换数据源名称
     */
    DataSourceType value() default DataSourceType.MASTER;
}
