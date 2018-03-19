package com.akingyin.dagger2androiddemo.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:31
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
