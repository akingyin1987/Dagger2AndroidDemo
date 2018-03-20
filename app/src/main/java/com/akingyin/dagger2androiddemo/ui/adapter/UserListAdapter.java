package com.akingyin.dagger2androiddemo.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.di.scope.ApplicationContext;
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
  public UserListAdapter(@ApplicationContext Context context) {
    super(null);
   //mInflater = LayoutInflater.from(activity);
  }

  @Override protected UserViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
   // return new UserViewHolder(mInflater,parent);
    return  null;
  }

  @Override protected void convert(UserViewHolder helper, UserEntity item) {
   // helper.bind(item);
  }
}
