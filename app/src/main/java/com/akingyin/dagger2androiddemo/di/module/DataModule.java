package com.akingyin.dagger2androiddemo.di.module;

import com.akingyin.dagger2androiddemo.db.dao.DaoSession;
import com.akingyin.dagger2androiddemo.db.dao.UserEntityDao;
import com.akingyin.dagger2androiddemo.db.data.source.Local;
import com.akingyin.dagger2androiddemo.db.data.source.Remote;
import com.akingyin.dagger2androiddemo.db.data.source.local.UsersLocalDataSource;
import com.akingyin.dagger2androiddemo.db.data.source.remote.UsersRemoteDataSource;
import com.akingyin.dagger2androiddemo.db.help.DbCore;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 12:08
 */
@Module
 abstract public  class DataModule {



  @Singleton
  @Provides
  static  DaoSession   getDaoSession(){
    return DbCore.getDaoSession();
  }


  @Provides
  @Singleton
  static UserEntityDao   getUserEntityDao(DaoSession  mDaoSession){
    return  mDaoSession.getUserEntityDao();
  }

  @Singleton
  @Binds
  @Local
  abstract UsersLocalDataSource provideUserLocalDataSource(UsersLocalDataSource dataSource);

  @Singleton
  @Binds
  @Remote
  abstract UsersRemoteDataSource provideUserRemoteDataSource(UsersRemoteDataSource dataSource);

}
