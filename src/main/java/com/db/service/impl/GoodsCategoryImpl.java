package com.db.service.impl;

import com.db.entity.GoodsCategory;
import com.db.mapper.GoodsCategoryMapper;
import com.db.service.GoodsCategoryService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-08 21:56
 */
public class GoodsCategoryImpl implements GoodsCategoryService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    // 获取到父类菜单
    public ArrayList<Object> getParents() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsCategoryMapper goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);
        // 4、调用方法
        List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectCategories();

        ArrayList<Object> categories = new ArrayList<>();
        for (GoodsCategory parentCategory : goodsCategories) {
            // 得到一级菜单
            if (parentCategory.isParent()) {
                categories.add(parentCategory);
            }
        }
        return categories;
    }

    // 得到子类菜单
    public List<GoodsCategory> getChildren(List<GoodsCategory> goodsCategories, int id) {
        List<GoodsCategory> chilrenCategories = new ArrayList<>();
        for (GoodsCategory goodsCategory : goodsCategories) {
            if (goodsCategory.getParentID() == id) {
                chilrenCategories.add(goodsCategory);
            }
        }
        //System.out.println("id: " + id + "chilrenCategories" + JSON.toJSONString(chilrenCategories));
        return chilrenCategories;
    }


    @Override
    public ArrayList<Object> getCategories() {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsCategoryMapper goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);
        // 4、调用方法
        List<GoodsCategory> goodsCategories = goodsCategoryMapper.selectCategories();

        ArrayList<Object> categories = new ArrayList<>();
        for (GoodsCategory parentCategory : goodsCategories) {
            // 得到一级菜单
            if (parentCategory.isParent()) {
                // 获取到二级菜单
                List<GoodsCategory> children = null;
                for (GoodsCategory chilrenCategory : goodsCategories) {
                    children = getChildren(goodsCategories, parentCategory.getCategoryID());
                }
                HashMap<Object, Object> parentMap = new HashMap<>();
                parentMap.put("categoryID", parentCategory.getCategoryID());
                parentMap.put("categoryName", parentCategory.getCategoryName());
                parentMap.put("isparent", parentCategory.getParentID());
                parentMap.put("children", children);
                //System.out.println("father：" + JSON.toJSONString(parentMap));
                categories.add(parentMap);
            }

        }

        sqlSession.close();
        return categories;
    }

    @Override
    public GoodsCategory selectCategoryByCategoryID(int categoryID) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsCategoryMapper goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);

        GoodsCategory goodsCategory = goodsCategoryMapper.selectCategoryByCategoryID(categoryID);
        sqlSession.close();
        return goodsCategory;
    }

    @Override
    public void addCategory(String categoryName, int parentID) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsCategoryMapper goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);
        // 4、调用方法
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setParent(parentID == -1);
        goodsCategory.setParentID(parentID);
        goodsCategory.setCategoryName(categoryName);
        goodsCategoryMapper.addCategory(goodsCategory);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteCategory(int categoryID) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsCategoryMapper goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);

        goodsCategoryMapper.deleteCategory(categoryID);

        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void modifyCategory(GoodsCategory goodsCategory) {
        //2、 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取userMapper接口的代理对象（Mapper代理开发）
        GoodsCategoryMapper goodsCategoryMapper = sqlSession.getMapper(GoodsCategoryMapper.class);

        goodsCategoryMapper.modifyCategory(goodsCategory);

        sqlSession.commit();
        sqlSession.close();
    }
}
