package com.akingyin.dagger2androiddemo.db.data.source;

import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.db.data.source.local.UsersLocalDataSource;
import com.akingyin.dagger2androiddemo.db.data.source.remote.UsersRemoteDataSource;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/23 11:46
 */

@Singleton
public class UserRepository implements  UsersDataSource{

  private   final UsersLocalDataSource   mUsersLocalDataSource;

  private   final UsersRemoteDataSource   mUsersRemoteDataSource;

  @Inject
  public UserRepository(@Local UsersLocalDataSource usersLocalDataSource,
     @Remote UsersRemoteDataSource usersRemoteDataSource) {
    mUsersLocalDataSource = usersLocalDataSource;
    mUsersRemoteDataSource = usersRemoteDataSource;
  }

  @Override public List<UserEntity> getAllUserentitys() {
    return mUsersLocalDataSource.getAllUserentitys();
  }

  @Override public void saveUserEntity(UserEntity userEntity) {
     mUsersLocalDataSource.saveUserEntity(userEntity);
  }

  @Override public void delectUserEntity(UserEntity userEntity) {
    mUsersLocalDataSource.delectUserEntity(userEntity);
  }
}
