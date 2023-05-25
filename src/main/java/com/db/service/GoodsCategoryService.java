package com.db.service;

import com.db.entity.GoodsCategory;
import java.util.ArrayList;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-08 21:54
 */
public interface GoodsCategoryService {
    ArrayList<Object> getParents();
    ArrayList<Object> getCategories();

    GoodsCategory selectCategoryByCategoryID(int categoryID);

    void addCategory(String categoryName, int parentID);

    void deleteCategory(int categoryID);

    void modifyCategory(GoodsCategory goodsCategory);
}
