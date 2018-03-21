package com.akingyin.dagger2androiddemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.base.BaseActivity;
import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.db.dao.UserEntityDao;
import com.akingyin.dagger2androiddemo.ui.adapter.UserListAdapter;
import java.util.Random;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:11
 */

public class MainActivity extends BaseActivity {
  @Inject UserEntityDao mUserEntityDao;
  @Inject UserListAdapter mUserListAdapter;
  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.recycler) RecyclerView mRecycler;
  @BindView(R.id.fab) FloatingActionButton mFab;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    if(null != getSupportActionBar()){
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
      mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          onBackPressed();
        }
      });
    }
    mRecycler.setLayoutManager(new LinearLayoutManager(this));
    mRecycler.setItemAnimator(new DefaultItemAnimator());
    mRecycler.setAdapter(mUserListAdapter);
    mUserListAdapter.setNewData(mUserEntityDao.loadAll());
  }

  @OnClick(R.id.fab) public void onViewClicked() {
    System.out.println("on--click");
    Random  random = new Random();
    UserEntity  userEntity = new UserEntity();
    userEntity.setAge(random.nextInt(100));
    userEntity.setName("name"+random.nextInt(100));
    userEntity.setTime(System.currentTimeMillis());
    mUserEntityDao.save(userEntity);
    mUserListAdapter.setNewData(mUserEntityDao.loadAll());
  }
}
