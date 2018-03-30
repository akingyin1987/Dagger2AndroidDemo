package com.akingyin.dagger2androiddemo.db.data.source;

import com.akingyin.dagger2androiddemo.db.BookEntity;
import java.util.List;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:16
 */

public interface BookDataSource {

  List<BookEntity>    findAllBooks();


  void    saveBook(BookEntity  bookEntity);

  void    delectBook(BookEntity  bookEntity);
}
