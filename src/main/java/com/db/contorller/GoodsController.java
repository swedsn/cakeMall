package com.db.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db.entity.Goods;
import com.db.service.GoodsService;
import com.db.service.impl.GoodsImpl;
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
public class GoodsController {

    GoodsService goodsService = new GoodsImpl();

    // 分页查询所有的商品
    @GetMapping("/selectGoodsByPage")
    public JSONObject selectGoodsByPage(int pageNum) {
        List<Goods> goods = goodsService.selectGoodsByPage(pageNum);
        int goodsNum = goodsService.getGoodsNum();
        JSONObject str = new JSONObject();
        str.put("total", goodsNum);
        str.put("goods", goods);
        return str;
    }

    // 按照商品名称或者是商品分类查询商品
    @GetMapping("/selectGoodsByCondition")
    public JSONObject selectGoodsByCondition(String goodsName,String goodsCategory) {
        List<Goods> goods = goodsService.selectGoodsByCondition(goodsName, goodsCategory);
        JSONObject str = new JSONObject();
        str.put("total", goods.size());
        str.put("users", goods);
        return str;
    }

    // 添加商品
    @GetMapping ("/addGoods")
    public JSONObject addGoods(Goods goods){
        System.out.println("goods ==>"+goods.getGoodsCategory() + goods.getGoodsDescription());
        goodsService.addGoods(goods);
        JSONObject str = new JSONObject();
        str.put("status", true);
        return str;
    }

    // 修改商品
    @GetMapping("/modifyGoods")
    public JSONObject modifyGoods(Goods goods) {
        System.out.println(goods.getGoodsExist());
        boolean flag = goodsService.modifyGoods(goods);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }

    // 删除商品
    @GetMapping("/deleteGoods")
    public JSONObject deleteGoods(int goodsID) {
        boolean flag = goodsService.deleteGoods(goodsID);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }
    // 查询商品
    @GetMapping("/selectGoods")
    public String selectGoods() {
        List<Goods> goods = goodsService.selectGoods();
        return JSON.toJSONString(goods);
    }

    @GetMapping("/selectGoodsByGoodsID")
    public String selectGoodsByGoodsID(int goodsID) {
        Goods goods = goodsService.selectGoodsByGoodsID(goodsID);
        return JSON.toJSONString(goods);
    }




    @GetMapping("/selectGoodsByText")
    public String selectGoodsByText(String text) {
        List<Goods> goods = goodsService.selectGoodsByText(text);
        return JSON.toJSONString(goods);
    }
}
