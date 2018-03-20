package com.akingyin.dagger2androiddemo.di.module;

import com.akingyin.dagger2androiddemo.db.dao.DaoSession;
import com.akingyin.dagger2androiddemo.db.dao.UserEntityDao;
import dagger.Module;
import dagger.Provides;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 12:08
 */
@Module
public class DataModule {

  protected final DaoSession mDaoSession;



  public DataModule(DaoSession daoSession) {
    mDaoSession = daoSession;
  }

  @Provides
  public UserEntityDao   getUserEntityDao(){
    return  mDaoSession.getUserEntityDao();
  }


}
