package com.akingyin.dagger2androiddemo.di.module;

import com.akingyin.dagger2androiddemo.di.component.ActivityComponent;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import com.akingyin.dagger2androiddemo.ui.MainActivity;
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

  @PerActivity
  @ContributesAndroidInjector
  abstract MainActivity contributeMainActivitytInjector();
  //
  //@ContributesAndroidInjector(modules = SecondActivityModule.class)
  //abstract SecondActivity contributeSecondActivityInjector();
}
