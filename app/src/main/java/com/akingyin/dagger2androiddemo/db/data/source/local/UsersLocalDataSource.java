package com.akingyin.dagger2androiddemo.db.data.source.local;

import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.db.dao.UserEntityDao;
import com.akingyin.dagger2androiddemo.db.data.source.UsersDataSource;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/23 11:51
 */

@Singleton
public class UsersLocalDataSource  implements UsersDataSource {

  private   final UserEntityDao   mUserEntityDao;

  @Inject
  public UsersLocalDataSource(UserEntityDao userEntityDao) {
    mUserEntityDao = userEntityDao;
  }

  @Override public List<UserEntity> getAllUserentitys() {
    return mUserEntityDao.loadAll();
  }

  @Override public void saveUserEntity(UserEntity userEntity) {
      mUserEntityDao.save(userEntity);
  }

  @Override public void delectUserEntity(UserEntity userEntity) {
      mUserEntityDao.delete(userEntity);
  }
}
