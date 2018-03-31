package com.akingyin.dagger2androiddemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import com.akingyin.dagger2androiddemo.ui.BookContract;
import com.akingyin.dagger2androiddemo.ui.BookPresenter;
import com.akingyin.dagger2androiddemo.ui.adapter.BookListAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:13
 */

@PerActivity public class BookListFragment extends Fragment implements BookContract.View {

  @Inject BookPresenter mBookPresenter;

  @Inject BookListAdapter mBookListAdapter;
  @BindView(R.id.recycler) RecyclerView mRecycler;
  Unbinder unbinder;
  @BindView(R.id.fab) FloatingActionButton mFab;

  @Inject public BookListFragment() {
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View root = inflater.inflate(R.layout.fragment_book, container, false);

    unbinder = ButterKnife.bind(this, root);
    mRecycler.setItemAnimator(new DefaultItemAnimator());
    mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    mRecycler.setAdapter(mBookListAdapter);
    mBookListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
      @Override public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        showModityBook(mBookListAdapter.getItem(position), position);
      }
    });
    mBookListAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
      @Override public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
        showDelectBook(mBookListAdapter.getItem(position), position);
        return true;
      }
    });
    return root;
  }

  @Override public void onResume() {
    super.onResume();
    mBookPresenter.takeView(this);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    mBookPresenter.dropView();
  }

  @Override public void showMessage(String msg) {
    Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override public void showBookList(List<BookEntity> bookEntities) {
    mBookListAdapter.setNewData(bookEntities);
  }

  @Override public void showAddBookDialog() {
    new MaterialDialog.Builder(getContext())
        .title("新增")
        .input("输入名称", "", new MaterialDialog.InputCallback() {
          @Override
          public void onInput(MaterialDialog dialog, CharSequence input) {
            BookEntity userEntity = new BookEntity();
            userEntity.setName(input.toString());
            mBookPresenter.saveBookEneity(userEntity);
            mBookListAdapter.addData(userEntity);

          }
        }).show();
  }

  @Override public void notifyBookDataOnPostion(int postion) {
    mBookListAdapter.notifyItemChanged(postion);
  }

  @Override public void notifyBooksData() {
    mBookListAdapter.notifyDataSetChanged();
  }

  @Override public void showModityBook(final BookEntity userEntity,final int postion) {
    new MaterialDialog.Builder(getContext())
        .title("修改")
        .input("输入名称", userEntity.getName(), new MaterialDialog.InputCallback() {
          @Override
          public void onInput(MaterialDialog dialog, CharSequence input) {

            userEntity.setName(input.toString());
            mBookPresenter.saveBookEneity(userEntity);
            notifyBookDataOnPostion(postion);

          }
        }).show();
  }

  @Override public void showDelectBook(final BookEntity userEntity, final int postion) {
    new MaterialDialog.Builder(getContext()).title("提示")
        .content("确定要删除当条数据")
        .negativeText("取消")
        .positiveText("确定")
        .onPositive(new MaterialDialog.SingleButtonCallback() {
          @Override
          public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
             mBookPresenter.delectBookEntity(userEntity,postion);
          }
        }).show();
  }

  @Override public void removeBookEntity(int postion) {
    mBookListAdapter.remove(postion);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @OnClick(R.id.fab) public void onViewClicked() {
    showAddBookDialog();
  }
}
