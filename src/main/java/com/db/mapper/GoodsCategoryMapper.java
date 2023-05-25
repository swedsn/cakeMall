package com.db.mapper;

import com.db.entity.GoodsCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author sag
 * @version 1.0
 * @date 2022-12-08 21:29
 */
public interface GoodsCategoryMapper {

    //@Select("select parent.categoryID, parent.categoryName, children.categoryName from goodscategory  as parent inner join goodscategory children on parent.categoryID = children.parentID order by categoryID;")
    //List<Map<String, Object>> selectCategories();

    @Select("select * from goodscategory order by isParent desc")
    List<GoodsCategory> selectCategories();

    @Select("select * from goodscategory where categoryID = #{categoryID}")
    GoodsCategory  selectCategoryByCategoryID(int categoryID);

    void addCategory(GoodsCategory goodsCategory);

    @Delete("delete from goodscategory where categoryID = #{CategoryID}")
    void deleteCategory(int CategoryID);

    @Update("update goodscategory set categoryName = #{categoryName}  where categoryID = #{categoryID}")
    void modifyCategory(GoodsCategory goodsCategory);

}
