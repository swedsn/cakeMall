package com.db.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.db.entity.Cart;
import com.db.service.CartService;
import com.db.service.StatisticService;
import com.db.service.impl.CartImpl;
import com.db.service.impl.StatisticImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-19 11:56
 */
@RestController
@CrossOrigin
public class CartController {

    // 添加购物车
    CartService cartService = new CartImpl();
    StatisticService statisticService = new StatisticImpl();
    @GetMapping("/addCart")
    public String addCart(Cart cart) {
        cart.setGoodsNum(1);
        //cart.setGoodsPriceSum(cart.getGoodsPriceSum());
        System.out.println(cart.getGoodsPriceSum());
        Boolean flag = cartService.addCart(cart);
        return JSON.toJSONString(flag);
    }

    @GetMapping("/selectCart")
    public JSONObject selectCart(String token) {
        JSONObject str = new JSONObject();
        DecodedJWT verify = JwtUtils.getClaimsByToken(token);
        String telephone = verify.getClaim("telephone").asString();
        List<Map<Object, Object>> carts = cartService.selectCart(telephone);
        Double goodsAllPrice = 0.0;
        int goodsAllNum = 0;
        for (Map<Object, Object> cart: carts){
            goodsAllPrice = goodsAllPrice + (Double) cart.get("goodsPriceSum");
            goodsAllNum = goodsAllNum + (Integer) cart.get("goodsNum");
        }

        BigDecimal b = new BigDecimal(goodsAllPrice);
        goodsAllPrice = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        str.put("carts", carts);
        str.put("goodsAllPrice", goodsAllPrice);
        str.put("goodsAllNum", goodsAllNum);
        str.put("cartCount", carts.size());
        return str;
    }


    @GetMapping("/modifyCart")
    public String modifyCart(String telephone, String goodsName, int goodsNum){
        Boolean flag = cartService.modifyCart(telephone, goodsName, goodsNum);
        return JSON.toJSONString(flag);
    }

    @GetMapping("/deleteCart")
    public String deleteCart(String token, String goodsName) {
        JSONObject str = new JSONObject();
        DecodedJWT verify = JwtUtils.getClaimsByToken(token);
        //System.out.println("伪造的："+verify);
        if (verify == null){
            return JSON.toJSONString(false);
        }
        String telephone = verify.getClaim("telephone").asString();
        Boolean flag = cartService.deleteCart(telephone, goodsName);
        return JSON.toJSONString(flag);
    }
}
