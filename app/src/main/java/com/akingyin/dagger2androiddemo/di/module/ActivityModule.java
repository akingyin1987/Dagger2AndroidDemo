package com.akingyin.dagger2androiddemo.di.module;

import android.content.Context;
import com.akingyin.dagger2androiddemo.base.BaseActivity;
import com.akingyin.dagger2androiddemo.di.component.ActivityComponent;
import com.akingyin.dagger2androiddemo.di.scope.ActivityContext;
import com.akingyin.dagger2androiddemo.ui.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 10:59
 */

@Module(subcomponents = { ActivityComponent.class})
public abstract class ActivityModule {

  @Binds
  @ActivityContext
  abstract Context bindActivityContext(BaseActivity activity);

  @ContributesAndroidInjector
  abstract MainActivity contributeMainActivitytInjector();


}
