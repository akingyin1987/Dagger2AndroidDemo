package com.akingyin.dagger2androiddemo.ui;

import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.akingyin.dagger2androiddemo.db.data.source.BookRepository;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:42
 */

@PerActivity
public class BookPresenter  implements BookContract.Presenter {

  private   final BookRepository   mBookRepository;

  private   BookContract.View   mView;

  @Inject
  public BookPresenter(BookRepository bookRepository) {
    mBookRepository = bookRepository;
  }

  @Override public void takeView(BookContract.View view) {
    this.mView = view;
  }

  @Override public List<BookEntity> getAllBookDatas() {
    return mBookRepository.findAllBooks();
  }

  @Override public void saveBookEneity(BookEntity userEntity) {
      mBookRepository.saveBook(userEntity);
      mView.showMessage("保存成功");
  }

  @Override public void dropView() {

  }

  @Override public void delectBookEntity(BookEntity userEntity, int postion) {
          mBookRepository.delectBook(userEntity);
          mView.showMessage("删除成功");
          mView.removeBookEntity(postion);
  }
}
