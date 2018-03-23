package com.akingyin.dagger2androiddemo.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.base.BaseActivity;
import com.akingyin.dagger2androiddemo.db.UserEntity;
import com.akingyin.dagger2androiddemo.db.dao.UserEntityDao;
import com.akingyin.dagger2androiddemo.ui.adapter.UserListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/19 11:11
 */

public class MainActivity extends BaseActivity implements UsersContract.View{
  @Inject UserEntityDao mUserEntityDao;
  @Inject UserListAdapter mUserListAdapter;
  @Inject UsersPresenter   mUsersPresenter;
  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.recycler) RecyclerView mRecycler;
  @BindView(R.id.fab) FloatingActionButton mFab;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mUsersPresenter.takeView(this);
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
    mUserListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
      @Override public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        UserEntity  userEntity = mUserListAdapter.getItem(position);
        showModityUser(userEntity,position);
      }
    });

    mUserListAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
      @Override public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
        UserEntity  userEntity = mUserListAdapter.getItem(position);
        showDelectUser(userEntity,position);
        return true;
      }
    });
  }

  @OnClick(R.id.fab) public void onViewClicked() {
      showAddUserDialog();
  }

  @Override public void showMessage(String msg) {
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
  }

  @Override public void showUserList(List<UserEntity> userEntities) {
     mUserListAdapter.setNewData(userEntities);
  }

  @Override public void showAddUserDialog() {
    new MaterialDialog.Builder(this)
        .title("新增")
        .input("输入名称", "", new MaterialDialog.InputCallback() {
          @Override
          public void onInput(MaterialDialog dialog, CharSequence input) {
              UserEntity   userEntity = new UserEntity();
              userEntity.setName(input.toString());
            mUsersPresenter.saveUserEneity(userEntity);
            mUserListAdapter.addData(userEntity);

          }
        }).show();
  }

  @Override public void notifyUserDataOnPostion(int postion) {
      mUserListAdapter.notifyItemChanged(postion);
  }

  @Override public void notifyUsersData() {
       mUserListAdapter.notifyDataSetChanged();
  }

  @Override public void showModityUser(final UserEntity userEntity, final int postion) {
    new MaterialDialog.Builder(this)
        .title("修改")
        .input("输入名称", userEntity.getName(), new MaterialDialog.InputCallback() {
          @Override
          public void onInput(MaterialDialog dialog, CharSequence input) {

            userEntity.setName(input.toString());
            mUsersPresenter.saveUserEneity(userEntity);
            notifyUserDataOnPostion(postion);

          }
        }).show();
  }

  @Override public void showDelectUser(final UserEntity userEntity, final int postion) {
        new MaterialDialog.Builder(this).title("提示")
            .content("确定要删除当条数据")
            .negativeText("取消")
            .positiveText("确定")
            .onPositive(new MaterialDialog.SingleButtonCallback() {
              @Override
              public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                mUsersPresenter.delectUserEntity(userEntity,postion);
              }
            }).show();
  }

  @Override public void removeUserEntity(int postion) {
    mUserListAdapter.remove(postion);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mUsersPresenter.dropView();
  }
}
