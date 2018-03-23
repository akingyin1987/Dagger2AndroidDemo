package com.akingyin.dagger2androiddemo.db.data.source;

import com.akingyin.dagger2androiddemo.db.UserEntity;
import java.util.List;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/23 11:49
 */

public interface UsersDataSource {

  List<UserEntity>   getAllUserentitys();

  void   saveUserEntity(UserEntity   userEntity);

  void   delectUserEntity(UserEntity  userEntity);
}
