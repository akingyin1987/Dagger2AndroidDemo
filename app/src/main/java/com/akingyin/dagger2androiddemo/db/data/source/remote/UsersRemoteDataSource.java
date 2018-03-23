package com.akingyin.dagger2androiddemo.db.data.source.remote;

import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.db.data.source.UsersDataSource;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/23 11:54
 */

@Singleton
public class UsersRemoteDataSource implements UsersDataSource {

  @Inject
  public UsersRemoteDataSource() {
  }

  @Override public List<UserEntity> getAllUserentitys() {
    return null;
  }

  @Override public void saveUserEntity(UserEntity userEntity) {

  }

  @Override public void delectUserEntity(UserEntity userEntity) {

  }
}
