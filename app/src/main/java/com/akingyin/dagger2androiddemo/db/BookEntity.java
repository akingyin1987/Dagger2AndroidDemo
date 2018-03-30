package com.akingyin.dagger2androiddemo.db;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author king
 * @version V1.0
 * @ Description:
 * @ Date 2018/3/30 17:06
 */

@Entity(nameInDb = "tb_book")
public class BookEntity  implements Serializable {
  private static final long serialVersionUID = -83890680909354992L;

  @Id(autoincrement = true)
  private   Long    id;

  @Property
  private   String   name;


  @Property
  private   String   author;

  @Generated(hash = 483464678)
  public BookEntity(Long id, String name, String author) {
      this.id = id;
      this.name = name;
      this.author = author;
  }

  @Generated(hash = 1373651409)
  public BookEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
