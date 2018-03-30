package com.akingyin.dagger2androiddemo.db.data.source.remote;

import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.akingyin.dagger2androiddemo.db.data.source.BookDataSource;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:23
 */

@Singleton
public class BookRemoteDataSource implements BookDataSource {

  @Inject
  public BookRemoteDataSource() {
  }

  @Override public List<BookEntity> findAllBooks() {
    return null;
  }

  @Override public void saveBook(BookEntity bookEntity) {

  }

  @Override public void delectBook(BookEntity bookEntity) {

  }
}
