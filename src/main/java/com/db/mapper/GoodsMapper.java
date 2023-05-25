package com.db.mapper;

import com.db.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-08 21:29
 */
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> selectGoodsLists();
    @Select("select * from goods limit #{numStart},10")
    List<Goods> selectGoodsListByPage(int numStart);
    @Select("select count(*) from goods")
    Integer getGoodsNum();
    List<Goods> selectGoodsByCondition(String goodsName, String goodsCategory);

    @Select("select * from goods where goodsID = #{goodsID}")
    Goods selectGoodsByGoodsID(int goodsID);
    void addGoods(Goods goods);

    @Update("update goods set goodsName = #{goodsName}, goodsPrice = #{goodsPrice}, goodsCategory = #{goodsCategory}, goodsExist = #{goodsExist},  goodsLogo = #{goodsLogo}, goodsDescription = #{goodsDescription}  where goodsID = #{goodsID}")
    boolean modifyGoods(Goods goods);

    @Delete("delete from goods where goodsID = #{goodsID}")
    boolean deleteGoods(int goodsID);

    @Select("select * from goods where goodsName like concat('%', #{text}, '%') or goodsCategory like concat('%', #{text}, '%')")
	List<Goods> selectGoodsListsByText(String text);

    @Select("select goodsID from goods where goodsName=#{goodsName}")
    int getGoodsIDByName(String goodsName);
}
