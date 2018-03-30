package com.akingyin.dagger2androiddemo.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.akingyin.dagger2androiddemo.R;
import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.MessageFormat;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:04
 */

public class BookViewHolder extends BaseViewHolder {

  @BindView(R.id.tv_bookname) TextView mTvBookname;
  @BindView(R.id.tv_bookauthor) TextView mTvBookauthor;

  public BookViewHolder(View view) {
    super(view);
    ButterKnife.bind(this, view);
  }

  public BookViewHolder(LayoutInflater inflater, ViewGroup parent) {
    this(inflater.inflate(R.layout.item_book, parent, false));
  }

  public   void    bind(BookEntity   bookEntity){
    mTvBookname.setText(MessageFormat.format("名称：{0}", bookEntity.getName()));
    mTvBookauthor.setText(MessageFormat.format("作者：{0}", bookEntity.getAuthor()));
  }
}
