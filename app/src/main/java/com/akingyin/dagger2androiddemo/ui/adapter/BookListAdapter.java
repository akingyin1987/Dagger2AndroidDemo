package com.akingyin.dagger2androiddemo.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.akingyin.dagger2androiddemo.di.qualifier.ActivityContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:10
 */

public class BookListAdapter  extends BaseQuickAdapter<BookEntity,BookViewHolder> {

  LayoutInflater   mInflater;
  @Inject
  public BookListAdapter(@ActivityContext Context  context) {
    super(null);

    System.out.println("context==="+(context  instanceof Activity));
    mInflater = LayoutInflater.from(context);
  }

  @Override protected BookViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
    return new BookViewHolder(mInflater,parent);
  }

  @Override protected void convert(BookViewHolder helper, BookEntity item) {
    helper.bind(item);
  }
}
