package com.akingyin.dagger2androiddemo.di.component;

import com.akingyin.dagger2androiddemo.base.BaseActivity;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:01
 */

@PerActivity
@Subcomponent(modules = { AndroidInjectionModule.class})
public interface ActivityComponent extends AndroidInjector<BaseActivity> {

  //每一个继承BaseActivity的Activity，都共享同一个SubComponent
  @Subcomponent.Builder
  abstract class Builder extends AndroidInjector.Builder<BaseActivity> {}





}
