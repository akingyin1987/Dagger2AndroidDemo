package com.akingyin.dagger2androiddemo.ui;

import com.akingyin.dagger2androiddemo.base.BasePresenter;
import com.akingyin.dagger2androiddemo.base.BaseView;
import com.akingyin.dagger2androiddemo.db.UserEntity;
import java.util.List;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/23 11:35
 */

public interface UsersContract {


  interface   View     extends BaseView<Presenter>{
    void    showMessage(String   msg);

    void    showUserList(List<UserEntity>   userEntities);

    void    showAddUserDialog();

    void    notifyUserDataOnPostion(int  postion);

    void    notifyUsersData();

    void   showModityUser(UserEntity  userEntity,int  postion);

    void   showDelectUser(UserEntity userEntity,int   postion);

    void   removeUserEntity(int  postion);
  }


  interface Presenter extends BasePresenter<View> {

    List<UserEntity>    getAllUserDatas();

    void   saveUserEneity(UserEntity  userEntity);

    void   delectUserEntity(UserEntity  userEntity,int  postion);

  }
}
