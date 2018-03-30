package com.akingyin.dagger2androiddemo.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.akingyin.dagger2androiddemo.di.qualifier.ActivityContext;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import com.akingyin.dagger2androiddemo.ui.MainActivity;
import com.akingyin.dagger2androiddemo.ui.UserModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 10:59
 */

@Module
public abstract class ActivityModule {

   @Binds
   @ActivityContext
   abstract Context bindActivityContext(Activity activity);


  @Provides
  @PerActivity
  static FragmentManager activityFragmentManager(AppCompatActivity activity) {
    return activity.getSupportFragmentManager();
  }


  @ContributesAndroidInjector(modules = UserModule.class)
  @PerActivity
  abstract MainActivity contributeMainActivitytInjector();



}
