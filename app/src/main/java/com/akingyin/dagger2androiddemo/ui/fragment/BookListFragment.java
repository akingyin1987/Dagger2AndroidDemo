package com.akingyin.dagger2androiddemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:13
 */

@PerActivity
public class BookListFragment  extends Fragment {

  @Inject
  public BookListFragment() {
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_book, container, false);
    return root;
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override public void onDestroy() {
    super.onDestroy();
  }
}
