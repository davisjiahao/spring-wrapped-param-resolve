package com.davis.param.resolver.annotation;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author didi
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ManhattanRequestParam {
    boolean required() default true;
    @AliasFor("name")
    String value() default "";
    @AliasFor("value")
    String name() default "";
}
