package com.lcz.dubbo.core.aop.annotation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 * 
 * @author luchunzhou
 * @date 2018/3/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
