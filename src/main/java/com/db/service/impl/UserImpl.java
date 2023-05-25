package com.db.service.impl;

import com.db.entity.User;
import com.db.mapper.UserMapper;
import com.db.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-06 20:22
 */
public class UserImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public List<User> selectUsers() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        List<User> users = userMapper.selectUsers();
        sqlSession.close();
        return users;
    }

    @Override
    public List<User> selectUsersByName(String username) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        List<User> users = userMapper.selectUsersByName(username);
        sqlSession.close();
        return users;
    }

    @Override
    public User selectUserByPhone(String telephone) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        User user = userMapper.selectUserByPhone(telephone);
        sqlSession.close();
        return user;
    }

    @Override
    public Boolean addUser(User user) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        Integer reslut = userMapper.addUser(user);
        System.out.println(reslut);

        sqlSession.commit();
        sqlSession.close();
        return reslut != null;
    }

    @Override
    public List<User> selectUsersByPage(Integer pageNum) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        int numStart = (pageNum-1)*10;
        List<User> users = userMapper.selectUsersByPage(numStart);
        sqlSession.close();
        return users;
    }

    @Override
    public Integer getUserNum() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        Integer userNum = userMapper.getUserNum();
        sqlSession.close();
        return userNum;
    }

    @Override
    public List<User> selectUsersByCondition(String telephone, String username, String address) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        List<User> users = userMapper.selectUsersByCondition(telephone, username, address);
        sqlSession.close();
        return users;
    }

    @Override
    public Boolean modifyUser(User user) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        boolean flag = userMapper.modifyUser(user);

        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public Boolean deleteUser(String telephone) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        boolean flag = userMapper.deleteUser(telephone);

        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public Boolean userLogin(String telephone, String password) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4、调用方法
        User user1 = userMapper.userLogin(telephone, password);

        sqlSession.close();
        return user1 != null;
    }


}
