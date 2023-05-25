package com.db.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db.entity.OrderInfo;
import com.db.service.OrderInfoService;
import com.db.service.impl.OrderInfoImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-13 14:46
 */

@RestController
@CrossOrigin
public class OrderInfoController {

    OrderInfoService orderInfoService = new OrderInfoImpl();

    // 分页展示订单信息
    @GetMapping("/selectOrderByPage")
    public JSONObject selectOrderByPage(int pageNum) {
        List<OrderInfo> order = orderInfoService.selectOrderByPage(pageNum);
        int orderNum = orderInfoService.getOrderNum();
        JSONObject str = new JSONObject();
        str.put("total", orderNum);
        str.put("order", order);
        return str;
    }

    // 通过条件查找用户订单
    @GetMapping("/selectOrderByCondition")
    public JSONObject selectOrderByCondition(String orderID,String orderStatus) {
        List<OrderInfo> order = orderInfoService.selectOrderByCondition(orderID, orderStatus);
        JSONObject str = new JSONObject();
        str.put("total", order.size());
        str.put("order", order);
        return str;
    }

    // 修改订单状态：由未发货到已发货
    @GetMapping("/modifyOrderStatus")
    public JSONObject modifyGoods(int orderID) {
        boolean flag = orderInfoService.modifyOrderStatus(orderID);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }

    //删除订单
    @GetMapping("/deleteOrder")
    public JSONObject deleteGoods(int orderID) {
        boolean flag = orderInfoService.deleteOrder(orderID);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }

//    @GetMapping("/selectOrderByTelephone")
//    public JSONObject selectOrderByTelephone(String token) {
//        DecodedJWT verify = JwtUtils.getClaimsByToken(token);
//        String telephone = verify.getClaim("telephone").asString();
//        List<Order> order = orderService.selectOrderByTelephone(telephone);
////        return JSON.toJSONString(order);
//        JSONObject str = new JSONObject();
//        str.put("total", order.size());
//        str.put("order", order);
//        return str;
//    }

    //@GetMapping ("/addOrder")
    //public JSONObject addOrder(OrderInfo order){
    //    order.setOrderContents(order.getOrderContents().trim());
    //    System.out.println("order ==>"+JSON.toJSONString(order));
    //    orderInfoService.addOrder(order);
    //    JSONObject str = new JSONObject();
    //    str.put("status", true);
    //    return str;
    //}

    //@GetMapping("/selectOrderFromUser")
    //public JSONObject selectOrderFromUser(String token,String text) {
    //    DecodedJWT verify = JwtUtils.getClaimsByToken(token);
    //    String telephone = verify.getClaim("telephone").asString();
    //    List<OrderInfo> order = orderInfoService.selectOrderFromUser(telephone, text);
    //    JSONObject str = new JSONObject();
    //    str.put("total", order.size());
    //    str.put("order", order);
    //    return str;
    //}

    //@GetMapping("/modifyGoods")
    //public JSONObject modifyGoods(Goods goods) {
    //    System.out.println(goods.getGoodsID());
    //    boolean flag = orderService.modifyGoods(goods);
    //    JSONObject str = new JSONObject();
    //    str.put("status", flag);
    //    return str;
    //}

    @GetMapping("/selectOrder")
    public String selectOrder() {
        List<OrderInfo> order = orderInfoService.selectOrder();
        return JSON.toJSONString(order);
    }

}
