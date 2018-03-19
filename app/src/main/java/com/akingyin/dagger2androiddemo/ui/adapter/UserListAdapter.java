package com.akingyin.dagger2androiddemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 17:31
 */

public class UserListAdapter  extends BaseQuickAdapter<UserEntity,UserViewHolder> {

  LayoutInflater  mInflater;
  @Inject
  public UserListAdapter(@PerActivity Context context) {
    super(null);
    mInflater = LayoutInflater.from(context);
  }

  @Override protected UserViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
    return new UserViewHolder(mInflater,parent);
  }

  @Override protected void convert(UserViewHolder helper, UserEntity item) {
    helper.bind(item);
  }
}
