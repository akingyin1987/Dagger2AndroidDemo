package com.akingyin.dagger2androiddemo.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 10:38
 */
@Qualifier // 限定符
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Type {

  String  value() default "";
}
