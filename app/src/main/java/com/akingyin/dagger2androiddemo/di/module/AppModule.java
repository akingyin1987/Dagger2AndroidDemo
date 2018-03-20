package com.akingyin.dagger2androiddemo.di.module;

import android.app.Application;
import android.content.Context;
import com.akingyin.dagger2androiddemo.di.scope.ApplicationContext;
import dagger.Binds;
import dagger.Module;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:27
 */

@Module
public abstract class AppModule {

  @Binds
  @ApplicationContext
  abstract Context bindContext(Application application);
}
