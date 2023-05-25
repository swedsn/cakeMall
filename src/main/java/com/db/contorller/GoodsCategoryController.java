package com.db.contorller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.db.entity.GoodsCategory;
import com.db.service.GoodsCategoryService;
import com.db.service.impl.GoodsCategoryImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-08 22:43
 */

@RestController
@CrossOrigin
public class GoodsCategoryController {
    GoodsCategoryService categoryService = new GoodsCategoryImpl();

    // 查询所有分类
    @GetMapping("/selectCategroies")
    public JSONObject selectCategroies() {
        ArrayList<Object> parentCategories = categoryService.getParents();
        ArrayList<Object> categories = categoryService.getCategories();
        JSONObject str = new JSONObject();
        str.put("parentCategories", parentCategories);
        str.put("categories", categories);
        return str;
    }

    // 添加分类
    @GetMapping("/addCategory")
    public void addCategory(String categoryName, int parentID){
        categoryService.addCategory(categoryName, parentID);
    }

    // 删除分类
    @GetMapping("/deleteCategory")
    public JSONObject deleteCategory(int categoryID){
        categoryService.deleteCategory(categoryID);
        JSONObject str = new JSONObject();
        str.put("status", true);
        return str;
    }

    // 修改分类
    @GetMapping("/modifyCategory")
    public JSONObject modifyCategory(GoodsCategory goodsCategory){
        categoryService.modifyCategory(goodsCategory);
        JSONObject str = new JSONObject();
        str.put("status", true);
        return str;
    }

    // 通过分类id获取到分类信息
    @GetMapping("/selectCategoryByCategoryID")
    public String selectCategoryByCategoryID(int categoryID){
        GoodsCategory goodsCategory = categoryService.selectCategoryByCategoryID(categoryID);
        return JSON.toJSONString(goodsCategory);
    }
}
