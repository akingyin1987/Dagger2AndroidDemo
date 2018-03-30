package com.akingyin.dagger2androiddemo.db.data.source.local;

import com.akingyin.dagger2androiddemo.db.BookEntity;
import com.akingyin.dagger2androiddemo.db.dao.BookEntityDao;
import com.akingyin.dagger2androiddemo.db.data.source.BookDataSource;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:17
 */

@Singleton
public class BookLocalDataSource  implements BookDataSource {

  private   final BookEntityDao   mBookEntityDao;

  @Inject
  public BookLocalDataSource(BookEntityDao bookEntityDao) {
    mBookEntityDao = bookEntityDao;
  }

  @Override public List<BookEntity> findAllBooks() {
    return mBookEntityDao.loadAll();
  }

  @Override public void saveBook(BookEntity bookEntity) {
       mBookEntityDao.save(bookEntity);
  }

  @Override public void delectBook(BookEntity bookEntity) {
      mBookEntityDao.delete(bookEntity);
  }
}
