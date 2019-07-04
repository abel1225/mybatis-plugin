package me.abel.mybatis.plugin;

import me.abel.mybatis.plugin.model.TestModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Abel.li
 * @description
 * @contact abel0130@163.com
 * @date 2019-07-04
 */
public class AppTest {

    @Test
    public void test() throws IOException {
        //读取配置文件内容
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSF = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession sqlS = sqlSF.openSession();

        //根据id查询
        try {
            //查询user_id=2的记录
            List<TestModel> list = sqlS.selectList("get", 2);
            for (TestModel user : list) {
                System.out.println("UserName:" + user.getName() + ",Addr:" + user.getCode());
            }
        } finally {
//            sqlS.close();
        }

        //添加数据
        try{
            TestModel addUser = new TestModel();
            addUser.setName("E");
            addUser.setCode("12345");
            sqlS.selectList("add",addUser);

            List<TestModel> list=sqlS.selectList("list");
            for (TestModel user :list){
                System.out.println("UserName:"+user.getName()+",Addr:"+user.getCode());
            }
        }finally {
//            sqlS.close();
        }

        //更新数据
        try{
            TestModel addUser = new TestModel();
            addUser.setId(3);
            addUser.setName("EF");
            addUser.setCode("12345");
            sqlS.selectList("upd",addUser);

            List<TestModel> list=sqlS.selectList("list");
            for (TestModel user :list){
                System.out.println("UserName:"+user.getName()+",Addr:"+user.getCode());
            }
        }finally {
//            sqlS.close();
        }

        //删除
        try{
            sqlS.selectList("del",2);

            List<TestModel> list=sqlS.selectList("list");
            for (TestModel user :list){
                System.out.println("UserName:"+user.getName()+",Addr:"+user.getCode());
            }
        }finally {
            sqlS.close();
        }
    }
}
