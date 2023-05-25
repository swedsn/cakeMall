package com.db.service;

import com.db.entity.Goods;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-13 14:41
 */
public interface GoodsService {

    // 查询所有
    List<Goods> selectGoods();

    // 分页查询商品
    List<Goods> selectGoodsByPage(Integer pageNum);

    // 获取到商品的数量
    int getGoodsNum();

    // 按照条件查询商品
    List<Goods> selectGoodsByCondition(String goodsName, String goodsCategory);

    // 通过商品id查询商品
    Goods selectGoodsByGoodsID(int goodsID);

    void addGoods(Goods goods);

    boolean modifyGoods(Goods goods);

    boolean deleteGoods(int goodsID);

    List<Goods> selectGoodsByText(String text);

}
