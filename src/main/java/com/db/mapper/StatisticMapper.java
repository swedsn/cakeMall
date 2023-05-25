package com.db.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-18 23:01
 */
public interface StatisticMapper {

    // 日销售金额
    @Select("select sum(orderinfo.orderPrice)  as dayMoney from orderinfo where orderTime like concat(DATE_FORMAT(NOW(), '%Y-%m-%d'),'%')")
    double getDayMoney();

    // 月销售金额
    @Select("select ROUND(sum(orderinfo.orderPrice) , 3)  as monthMoney from orderinfo where orderTime like concat(DATE_FORMAT(NOW(), '%Y-%m'),'%')")
    double getMonthMoney();

    // 日销售订单
    @Select("select count(*) from orderinfo where orderTime like concat(DATE_FORMAT(NOW(), '%Y-%m-%d'), '%')")
    int getDaySale();

    // 月销售订单
    @Select("select count(*) from orderinfo where orderTime like concat(DATE_FORMAT(NOW(), '%Y-%m'), '%')")
    int getMonthSale();

    // 获取总销售量前5的产品
    @Select("select goodsID, sum(goodsNum) as allSale from orderitem group by goodsID order by allSale desc limit 0,5")
    List<Map<Object, Object>> getAllGoods();

    //通过总销售量前七的商品id查询到日销售量
    @Select("select count(*) as allSale from orderitem WHERE orderID IN (select orderID from orderinfo where orderTime like concat(DATE_FORMAT(NOW(), '%Y-%m-%d'), '%')) and goodsID = #{goodsID}")
    int getDayGoods(int goodsID);

    //通过总销售量前七的商品id查询到月销售量
    @Select("select count(*) as allSale from orderitem where orderID IN (select orderID from orderinfo where orderTime like concat(DATE_FORMAT(NOW(), '%Y-%m'), '%')) and goodsID=#{goodsID}")
    int getMonthGoods(int goodsID);

    @Select("select goodsName from goods where goodsID=#{goodsID}")
    String getGoodsName(int goodsID);

    @Select("select goodsPrice from goods  where goodsName=#{goodsName}")
    int getGoodsPrice(String goodsName);

    // 获取每一个月的销售金额
    @Select("select sum(orderinfo.orderPrice)  as monthMoney from orderinfo where orderTime like concat(#{month},'%');")
    String getAllMonthMoney(String month);

    // 热销商品统计
    @Select("select goodsID, sum(goodsNum) as allSale from orderitem group by goodsID order by allSale desc limit 0,4")
    List<Map<Object, Object>> hotSale();

    // 新品统计
    @Select("select goodsID from goods order by goodsID desc limit 0,4")
    List<Map<Object, Object>> newGoods();
}
