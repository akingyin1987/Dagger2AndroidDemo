package com.akingyin.dagger2androiddemo;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.akingyin.dagger2androiddemo.db.help.DbCore;
import com.akingyin.dagger2androiddemo.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 10:26
 */

public class DaggerApp  extends Application implements HasActivityInjector {

  @Inject DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    Log.d(DaggerApp.class.getName(),"onCreate");
    DbCore.init(getApplicationContext());
    DbCore.enableQueryBuilderLog();

    DaggerAppComponent.builder()
        .application(this)

        .build().inject(this);
  }

  @Override public AndroidInjector<Activity> activityInjector() {
    return dispatchingAndroidInjector;
  }
}
