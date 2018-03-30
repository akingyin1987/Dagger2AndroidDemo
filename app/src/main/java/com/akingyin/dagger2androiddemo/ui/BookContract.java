package com.akingyin.dagger2androiddemo.ui;

import com.akingyin.dagger2androiddemo.base.BasePresenter;
import com.akingyin.dagger2androiddemo.base.BaseView;
import com.akingyin.dagger2androiddemo.db.BookEntity;
import java.util.List;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:39
 */

public interface BookContract {


  interface   View     extends BaseView<BookContract.Presenter> {
    void    showMessage(String   msg);

    void    showBookList(List<BookEntity> bookEntities);

    void    showAddBookDialog();

    void    notifyBookDataOnPostion(int  postion);

    void    notifyBooksData();

    void   showModityBook(BookEntity  userEntity,int  postion);

    void   showDelectBook(BookEntity userEntity,int   postion);

    void   removeBookEntity(int  postion);
  }


  interface Presenter extends BasePresenter<BookContract.View> {

    List<BookEntity>    getAllBookDatas();

    void   saveBookEneity(BookEntity  userEntity);

    void   delectBookEntity(BookEntity  userEntity,int  postion);

  }
}
