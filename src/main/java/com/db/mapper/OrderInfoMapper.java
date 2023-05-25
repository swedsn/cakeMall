package com.db.mapper;

import com.db.entity.Goods;
import com.db.entity.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-08 21:29
 */
public interface OrderInfoMapper {

    @Select("select * from orderinfo")
    List<OrderInfo> selectOrderInfo();

    // 分页查询订单信息，每页10条
    @Select("select * from orderinfo limit #{numStart},10")
    List<OrderInfo> selectOrderInfoByPage(int numStart);

    // 计算所有的订单的数量
    @Select("select count(*) from orderinfo")
    Integer getOrderInfoNum();

    // 按条件查询订单信息
    List<OrderInfo> selectOrderInfoByCondition(String orderID, String orderStatus);

    // 修改订单信息从未发货到已发货
    @Update("update orderinfo set orderStatus = '已发货', orderTime = #{time} where orderID = #{orderID}")
    boolean modifyOrderStatus(int orderID, String time);
    // 删除订单
    @Delete("delete from orderinfo where orderID = #{orderID}")
    boolean deleteOrderInfo(int orderID);

    @Update("update orderinfo set orderPrice = #{orderPrice}, orderStatus = #{orderStatus}, orderContents = #{orderContents}, orderTime = #{orderTime}  where orderID = #{orderID}")
    boolean modifyOrder(Goods goods);

    // 添加订单信息
    int addOrder(OrderInfo orderInfo);




    //@Select("select orderStatus, orderAmount, orderPrice, orderPaytype, orderReservetime, orderRealtime from orderitem where orderTelephone= #{telephone}")
    //List<OrderInfo> selectOrderByTelephone(String telephone);

    //List<OrderInfo> selectOrderFromUser(String telephone, String text);

    //@Insert("insert into orderitem(orderID, goodsID, goodsNum) values (#{orderID}, #{goodsID}, #{goodsNum})")
    //boolean addOrderitem(Orderitem orderitem);

}
