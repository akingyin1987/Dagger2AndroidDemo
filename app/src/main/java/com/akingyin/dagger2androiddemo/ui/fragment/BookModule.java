package com.akingyin.dagger2androiddemo.ui.fragment;

import android.app.Activity;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import com.akingyin.dagger2androiddemo.di.scope.PerFragment;
import com.akingyin.dagger2androiddemo.ui.BookActivity;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:24
 */

@Module
public abstract class BookModule {

  @PerFragment
  @ContributesAndroidInjector
  abstract BookListFragment tasksFragment();


  @Binds
  @PerActivity
  abstract Activity activity(BookActivity example1Activity);



}
