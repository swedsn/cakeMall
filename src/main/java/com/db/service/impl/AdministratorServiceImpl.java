package com.db.service.impl;

import com.db.entity.Administrator;
import com.db.mapper.AdministratorMapper;
import com.db.service.AdministratorService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-22 10:54
 */
public class AdministratorServiceImpl implements AdministratorService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public boolean login(Administrator administrator) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        AdministratorMapper administratorMapper = sqlSession.getMapper(AdministratorMapper.class);
        // 4、调用方法
        Administrator user = administratorMapper.login(administrator);

        sqlSession.close();
        return user != null;
    }
}
