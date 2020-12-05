package com.njcebbank.merchants.annotation;

import java.lang.annotation.*;

/**
 * @author：不许人间见白头 Time：2020/12/4 9:13
 */
/*
@Retention注解表示Annotation的保留策略
RetentionPolicy.Class：运行时不保留，不可以通过反射读取。
RetentionPolicy.RUNTIME：运行是保留，可以通过反射读取。
RetentionPolicy.SOURCE：丢弃。
*@Target(value=ElementType.METHOD) 用于放在什么上面  method 方法 type 类或者接口 field 字段
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserRoles {
    String[] roles() default {};
}
