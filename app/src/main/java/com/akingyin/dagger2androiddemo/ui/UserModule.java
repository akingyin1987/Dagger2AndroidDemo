package com.akingyin.dagger2androiddemo.ui;

import android.content.Context;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import dagger.Module;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 18:19
 */

@Module
public abstract class UserModule {

  @PerActivity
  abstract Context  getContext();

}
