package com.db.service;

import com.db.entity.Cart;
import java.util.List;
import java.util.Map;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-19 12:04
 */
public interface CartService {

    Boolean addCart(Cart cart);

    List<Map<Object, Object>> selectCart(String telephone);

    Boolean deleteCart(String telephone, String goodsName);

    Boolean modifyCart(String telephone, String goodsName, int goodsNum);
}
