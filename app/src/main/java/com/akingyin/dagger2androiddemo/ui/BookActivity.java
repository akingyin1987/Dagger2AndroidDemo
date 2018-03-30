package com.akingyin.dagger2androiddemo.ui;

import android.os.Bundle;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.ui.fragment.BookListFragment;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:53
 */

public class BookActivity  extends DaggerAppCompatActivity {

  @Inject
  BookListFragment   mBookListFragment;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    BookListFragment   bookListFragment  =
        (BookListFragment) getSupportFragmentManager().findFragmentById(R.id.fl_container);
    if(null == bookListFragment){
      getSupportFragmentManager().beginTransaction().add(R.id.fl_container,mBookListFragment).commit();
    }else{
      getSupportFragmentManager().beginTransaction().add(R.id.fl_container,bookListFragment).commit();
    }
  }
}
