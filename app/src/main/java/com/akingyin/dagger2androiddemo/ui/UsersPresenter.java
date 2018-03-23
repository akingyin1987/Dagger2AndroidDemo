package com.akingyin.dagger2androiddemo.ui;

import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.db.data.source.UserRepository;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/23 11:44
 */

@PerActivity
public class UsersPresenter  implements  UsersContract.Presenter {
  private  final  UserRepository   mUserRepository;

  @Inject
  public UsersPresenter(UserRepository userRepository) {
    mUserRepository = userRepository;
  }

  @Override public List<UserEntity> getAllUserDatas() {
    return null;
  }

  @Override public void saveUserEneity(UserEntity userEntity) {
    mUserRepository.saveUserEntity(userEntity);
    mView.showMessage("保存成功");
  }

  @Override public void delectUserEntity(UserEntity userEntity, int postion) {
    mUserRepository.delectUserEntity(userEntity);
    mView.showMessage("删除成功");
    mView.removeUserEntity(postion);
  }

  protected    UsersContract.View  mView;
  @Override public void takeView(UsersContract.View view) {
    this.mView = view;
  }

  @Override public void dropView() {

  }
}
