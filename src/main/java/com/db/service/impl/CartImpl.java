package com.db.service.impl;

import com.db.entity.Cart;
import com.db.entity.Goods;
import com.db.mapper.CartMapper;
import com.db.mapper.GoodsMapper;
import com.db.service.CartService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-19 12:05
 */
public class CartImpl implements CartService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public Boolean addCart(Cart cart) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        Cart cart1 = cartMapper.selectCartByUser(cart.getTelephone(), cart.getGoodsID());
        if (cart1 == null) {
            cartMapper.addCart(cart);
        } else {
            Goods goods = goodsMapper.selectGoodsByGoodsID(cart.getGoodsID());
            boolean flag = cartMapper.modifyCart(cart1.getGoodsNum() + cart.getGoodsNum(), cart.getTelephone(), cart.getGoodsID(), goods.getGoodsPrice() * (cart1.getGoodsNum() + cart.getGoodsNum()));
        }
        // 4、调用方法
        return true;
    }

    @Override
    public List<Map<Object, Object>> selectCart(String telephone) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        List<Map<Object, Object>> cartlist = new ArrayList<>();

        List<Cart> carts = cartMapper.selectCart(telephone);
        for (Cart cart : carts) {
            HashMap<Object, Object> cartMap = new HashMap<>();
            Goods goods = goodsMapper.selectGoodsByGoodsID(cart.getGoodsID());
            cartMap.put("goodsLogo", goods.getGoodsLogo());
            cartMap.put("goodsName", goods.getGoodsName());
            cartMap.put("goodsNum", cart.getGoodsNum());
            cartMap.put("goodsPriceSum", cart.getGoodsPriceSum());
            cartMap.put("goodsDescription", goods.getGoodsDescription());
            cartlist.add(cartMap);
        }

        return cartlist;
    }

    @Override
    public Boolean deleteCart(String telephone, String goodsName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        int goodsID = goodsMapper.getGoodsIDByName(goodsName);
        System.out.println("goodsName" + goodsName + "goodsID" + goodsID);
        return cartMapper.deletCart(telephone, goodsID);
    }

    @Override
    public Boolean modifyCart(String telephone, String goodsName, int goodsNum) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);

        int goodsID = goodsMapper.getGoodsIDByName(goodsName);
        Goods goods = goodsMapper.selectGoodsByGoodsID(goodsID);

        return cartMapper.modifyCart(goodsNum, telephone, goodsID, goodsNum*goods.getGoodsPrice());
    }
}
