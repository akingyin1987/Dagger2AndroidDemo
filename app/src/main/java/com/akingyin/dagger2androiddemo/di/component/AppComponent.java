package com.akingyin.dagger2androiddemo.di.component;

import com.akingyin.dagger2androiddemo.DaggerApp;
import com.akingyin.dagger2androiddemo.di.module.ActivityModule;
import com.akingyin.dagger2androiddemo.di.module.AppModule;
import com.akingyin.dagger2androiddemo.di.module.DataModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 10:50
 */

@Singleton
@Component(modules = { DataModule.class,AppModule.class, ActivityModule.class
              ,AndroidInjectionModule.class,
             AndroidSupportInjectionModule.class,
   })
public interface AppComponent extends AndroidInjector<DaggerApp> {

  @Component.Builder
  interface Builder {

    @BindsInstance
    AppComponent.Builder application(DaggerApp application);

  //  AppComponent.Builder dataModel(DataModule  dataModule);
    AppComponent build();
  }

  //UserEntityDao   getUserEntityDao();



}
