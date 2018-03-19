package com.akingyin.dagger2androiddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.base.BaseActivity;
import com.akingyin.dagger2androiddemo.db.dao.UserEntityDao;
import com.akingyin.dagger2androiddemo.ui.adapter.UserListAdapter;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:11
 */

public class MainActivity  extends BaseActivity {
  @Inject
  UserEntityDao   mUserEntityDao;
  @Inject
  UserListAdapter  mUserListAdapter;
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    System.out.println("null == mUserEntityDao"+(null == mUserEntityDao));
    System.out.println("null == ");
  }
}
