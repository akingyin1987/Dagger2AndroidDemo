package com.akingyin.dagger2androiddemo.ui;

import android.app.Activity;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import dagger.Binds;
import dagger.Module;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 18:19
 */

@Module
public abstract class UserModule {

  @Binds
  @PerActivity
  abstract Activity activity(MainActivity example1Activity);


  @Binds
  @PerActivity
  abstract  UsersContract.Presenter  tackPresenter(UsersPresenter   mUsersPresenter);
}
