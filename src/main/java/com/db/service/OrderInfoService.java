package com.db.service;

import com.db.entity.OrderInfo;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-14 14:04
 */
public interface OrderInfoService {

    List<OrderInfo> selectOrder();

    List<OrderInfo> selectOrderByCondition(String orderID, String orderStatus);

    List<OrderInfo> selectOrderByPage(int num);

    int getOrderNum();

    Boolean modifyOrderStatus(int orderID);

    Boolean deleteOrder(int orderID);

    //Boolean addOrder(OrderInfo orderInfo);

    //List<Order> selectOrderByTelephone(String telephone);
    //List<OrderInfo> selectOrderFromUser(String telephone, String text);
}
