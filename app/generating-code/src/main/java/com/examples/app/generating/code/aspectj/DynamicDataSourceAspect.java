package com.examples.app.generating.code.aspectj;

import com.examples.app.generating.code.common.annotation.DS;
import com.examples.app.generating.code.common.datasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源切面
 *
 * @author liangjinlong-CT00345
 * @date 2023-12-28 10:35
 */
@Aspect
@Order(1)
@Component
public class DynamicDataSourceAspect {

    /**
     * mybatis-plus切点
     */
    @Pointcut("execution(* com.examples.app.generating.code.common.base.BasePlusMapper+.*(..))")
    public void plusMapperCut() { }

    @Around("plusMapperCut()")
    public Object plusMapperAround(ProceedingJoinPoint point) throws Throwable {
        try {
            Class[] clz = point.getTarget().getClass().getInterfaces();
            if (clz.length != 1) {
                return point.proceed();
            }
            Class<?> mapperClz = clz[0];
            DS mapperAnnotation = mapperClz.getAnnotation(DS.class);
            // 方法的可以覆盖类上的注解
            for (Method method : mapperClz.getDeclaredMethods()) {
                DS methodAnnotation = method.getAnnotation(DS.class);
                if (method.getName().equals(point.getSignature().getName()) && methodAnnotation != null) {
                    mapperAnnotation = methodAnnotation;
                }
            }
            if (mapperAnnotation != null) {
                DynamicDataSourceContextHolder.setDataSourceType(mapperAnnotation.value().name());
            }
            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

}
