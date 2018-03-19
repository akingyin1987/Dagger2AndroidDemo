package com.akingyin.dagger2androiddemo.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:00
 */

public class BaseActivity  extends AppCompatActivity implements HasFragmentInjector,
    HasSupportFragmentInjector {

  @Inject DispatchingAndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector;
  @Inject DispatchingAndroidInjector<android.app.Fragment> frameworkFragmentInjector;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);

    super.onCreate(savedInstanceState);
  }

  @Override public AndroidInjector<Fragment> fragmentInjector() {
    return frameworkFragmentInjector;
  }

  @Override public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
    return supportFragmentInjector;
  }
}
