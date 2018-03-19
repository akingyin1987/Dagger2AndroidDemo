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
 * @ Date 2018/3/19 10:27
 */

@Entity(nameInDb = "tb_user")
public class UserEntity  implements Serializable {
  private static final long serialVersionUID = -1734371345795278920L;

  @Id(autoincrement = true)
  private    Long    id;

  @Property
  private    String    name;

  @Property
  private   int    age;

  @Property
  private   Long    time;

  @Generated(hash = 2136597568)
  public UserEntity(Long id, String name, int age, Long time) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.time = time;
  }

  @Generated(hash = 1433178141)
  public UserEntity() {
  }

  public Long getId() {
      return this.id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getAge() {
      return this.age;
  }

  public void setAge(int age) {
      this.age = age;
  }

  public Long getTime() {
      return this.time;
  }

  public void setTime(Long time) {
      this.time = time;
  }
}
