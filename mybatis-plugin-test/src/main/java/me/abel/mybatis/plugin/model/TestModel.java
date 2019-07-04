package me.abel.mybatis.plugin.model;


/**
 * @description
 * @author Abel.li
 * @contact abel0130@163.com
 * @date 2019-07-04
 * @version
 */
public class TestModel {

  private long id;
  private String name;
  private String code;

  public final long getId() {
    return id;
  }

  public TestModel setId(long id) {
    this.id=id;
    return this;
  }

  public final String getName() {
    return name;
  }

  public TestModel setName(String name) {
    this.name=name;
    return this;
  }

  public final String getCode() {
    return code;
  }

  public TestModel setCode(String code) {
    this.code=code;
    return this;
  }
}
