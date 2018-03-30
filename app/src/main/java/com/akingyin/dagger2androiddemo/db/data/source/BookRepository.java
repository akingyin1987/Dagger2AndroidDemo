package com.akingyin.dagger2androiddemo.db.data.source;

import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.akingyin.dagger2androiddemo.db.data.source.local.BookLocalDataSource;
import com.akingyin.dagger2androiddemo.db.data.source.remote.BookRemoteDataSource;
import com.akingyin.dagger2androiddemo.di.scope.PerActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:43
 */

@PerActivity
public class BookRepository  implements  BookDataSource {

  private final BookRemoteDataSource   mRemoteDataSource;

  private final BookLocalDataSource    mLocalDataSource;

  @Inject
  public BookRepository(@Remote BookRemoteDataSource remoteDataSource,
      @Local BookLocalDataSource localDataSource) {
    mRemoteDataSource = remoteDataSource;
    mLocalDataSource = localDataSource;
  }

  @Override public List<BookEntity> findAllBooks() {
    return mLocalDataSource.findAllBooks();
  }

  @Override public void saveBook(BookEntity bookEntity) {
      mLocalDataSource.saveBook(bookEntity);
  }

  @Override public void delectBook(BookEntity bookEntity) {
       mLocalDataSource.delectBook(bookEntity);
  }
}
