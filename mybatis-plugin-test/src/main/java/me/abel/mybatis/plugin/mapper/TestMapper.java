package me.abel.mybatis.plugin.mapper;

import me.abel.mybatis.plugin.model.TestModel;

import java.util.List;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2019-07-04
 */
public interface TestMapper {

    void add(TestModel model);
    List<TestModel> list();
}
