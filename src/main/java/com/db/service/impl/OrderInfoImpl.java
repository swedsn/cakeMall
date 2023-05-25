package com.db.service.impl;

import com.db.entity.OrderInfo;
import com.db.mapper.OrderInfoMapper;
import com.db.service.OrderInfoService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-14 14:04
 */
public class OrderInfoImpl implements OrderInfoService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<OrderInfo> selectOrder() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        OrderInfoMapper orderInfoMapper = sqlSession.getMapper(OrderInfoMapper.class);
        // 4、调用方法
        List<OrderInfo> order = orderInfoMapper.selectOrderInfo();
        sqlSession.close();
        return order;
    }

    @Override
    public List<OrderInfo> selectOrderByCondition(String orderID, String orderStatus) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        OrderInfoMapper orderInfoMapper = sqlSession.getMapper(OrderInfoMapper.class);
        // 4、调用方法
        List<OrderInfo> order = orderInfoMapper.selectOrderInfoByCondition(orderID, orderStatus);
        sqlSession.close();
        return order;
    }

    @Override
    public List<OrderInfo> selectOrderByPage(int num) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        OrderInfoMapper orderInfoMapper = sqlSession.getMapper(OrderInfoMapper.class);
        // 4、调用方法
        int numStart = (num - 1) * 10;
        List<OrderInfo> order = orderInfoMapper.selectOrderInfoByPage(numStart);
        sqlSession.close();
        return order;
    }

    @Override
    public int getOrderNum() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        OrderInfoMapper orderInfoMapper = sqlSession.getMapper(OrderInfoMapper.class);
        // 4、调用方法
        int total = orderInfoMapper.getOrderInfoNum();
        sqlSession.close();
        return total;
    }

    @Override
    public Boolean modifyOrderStatus(int orderID) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        OrderInfoMapper orderInfoMapper = sqlSession.getMapper(OrderInfoMapper.class);

        // 4、调用方法
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Boolean flag = orderInfoMapper.modifyOrderStatus(orderID, time);

        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public Boolean deleteOrder(int orderID) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        OrderInfoMapper orderInfoMapper = sqlSession.getMapper(OrderInfoMapper.class);
        // 4、调用方法
        Boolean flag = orderInfoMapper.deleteOrderInfo(orderID);

        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    //@Override
    //public Boolean addOrder(OrderInfo order) {
    //    SqlSession sqlSession = sqlSessionFactory.openSession();
    //    // 3、获取userMapper接口的代理对象（Mapper代理开发）
    //    OrderInfoMapper orderMapper = sqlSession.getMapper(OrderInfoMapper.class);
    //    CartMapper  cartMapper = sqlSession.getMapper(CartMapper.class);
    //    GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
    //
    //    // 4、调用方法
    //    orderMapper.addOrder(order);
    //    String orderContents = order.getOrderContents();
    //    String[] strs = orderContents.split(",");
    //    for (String str : strs) {
    //
    //        int num = Integer.parseInt(str.substring(str.length()-1, str.length()));
    //        String goodsName = str.substring(0, str.length()-2);
    //        Orderitem orderitem = new Orderitem();
    //
    //        cartMapper.deletCart(order.getOrderTelephone(),goodsMapper.getGoodsIDByName(goodsName));
    //
    //        orderitem.setOrderID(order.getOrderID());
    //        orderitem.setGoodsID(goodsMapper.getGoodsIDByName(goodsName));
    //        orderitem.setGoodsNum(num);
    //        orderMapper.addOrder(order);
    //    }
    //
    //    sqlSession.commit();
    //    sqlSession.close();
    //    return true;
    //}

    //@Override
    //public List<Order> selectOrderByTelephone(String telephone) {
    //    //2、 获取SqlSession对象，用它来执行sql
    //    SqlSession sqlSession = sqlSessionFactory.openSession();
    //    // 3、获取userMapper接口的代理对象（Mapper代理开发）
    //    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    //    List<Order> orders = orderMapper.selectOrderByTelephone(telephone);
    //    return orders;
    //}

    //@Override
    //public List<OrderInfo> selectOrderFromUser(String telephone, String text) {
    //    //2、 获取SqlSession对象，用它来执行sql
    //    SqlSession sqlSession = sqlSessionFactory.openSession();
    //    // 3、获取userMapper接口的代理对象（Mapper代理开发）
    //    OrderInfoMapper orderMapper = sqlSession.getMapper(OrderInfoMapper.class);
    //    // 4、调用方法
    //
    //    List<OrderInfo> order = orderMapper.selectOrderFromUser(telephone, text);
    //    sqlSession.close();
    //    return order;
    //}


}
