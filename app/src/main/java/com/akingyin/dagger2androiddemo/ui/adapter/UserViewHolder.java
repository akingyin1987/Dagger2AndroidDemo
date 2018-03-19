package com.akingyin.dagger2androiddemo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 17:23
 */

public class UserViewHolder extends BaseViewHolder {

  @BindView(R.id.tv_name) TextView mTvName;
  @BindView(R.id.tv_age) TextView mTvAge;

  public UserViewHolder(View view) {
    super(view);
    ButterKnife.bind(this, view);
  }

  public UserViewHolder(LayoutInflater inflater, ViewGroup parent) {
    this(inflater.inflate(R.layout.item_user, parent, false));
  }

  public   void   bind(UserEntity  userEntity){
    mTvAge.setText(String.valueOf(userEntity.getAge()));
    mTvName.setText(String.valueOf(userEntity.getName()));
  }
}
