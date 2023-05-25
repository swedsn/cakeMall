package com.db.service.impl;


import com.db.entity.Goods;
import com.db.mapper.GoodsMapper;
import com.db.service.GoodsService;
import com.db.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-13 14:41
 */
public class GoodsImpl implements GoodsService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Goods> selectGoods() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        List<Goods> goods = goodsMapper.selectGoodsLists();
        sqlSession.close();
        return goods;
    }

    @Override
    public List<Goods> selectGoodsByPage(Integer pageNum) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        int numStart = (pageNum-1)*10;
        List<Goods> goods = goodsMapper.selectGoodsListByPage(numStart);
        sqlSession.close();
        return goods;
    }

    @Override
    public int getGoodsNum() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法

        int num = goodsMapper.getGoodsNum();
        sqlSession.close();
        return num;
    }

    @Override
    public List<Goods> selectGoodsByCondition(String goodsName, String goodsCategory) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        List<Goods> goods = goodsMapper.selectGoodsByCondition(goodsName, goodsCategory);
        sqlSession.close();
        return goods;
    }

    @Override
    public Goods selectGoodsByGoodsID(int goodsID) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        Goods goods = goodsMapper.selectGoodsByGoodsID(goodsID);
        sqlSession.close();
        return goods;
    }

    @Override
    public void addGoods(Goods goods) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        goodsMapper.addGoods(goods);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public boolean modifyGoods(Goods goods) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        boolean flag = goodsMapper.modifyGoods(goods);
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public boolean deleteGoods(int goodsID) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        boolean flag = goodsMapper.deleteGoods(goodsID);

        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public List<Goods> selectGoodsByText(String text) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        // 4、调用方法
        List<Goods> goods = goodsMapper.selectGoodsListsByText(text);
        sqlSession.close();
        return goods;
    }
}
