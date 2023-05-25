package com.db.mapper;

import com.db.entity.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-19 11:58
 */
public interface CartMapper {

    @Insert("insert into cart(telephone, goodsID, goodsNum, goodsPriceSum) value(#{telephone}, #{goodsID},#{goodsNum},#{goodsPriceSum})")
    boolean addCart(Cart cart);

    @Select("select * from cart where telephone=#{telephone}")
    List<Cart> selectCart(String telephone);

    @Select("select * from cart where telephone=#{telephone} and goodsID = #{goodsID}")
    Cart selectCartByUser(String telephone, int goodsID);

    @Update("update cart set goodsNum = #{goodsNum},goodsPriceSum = #{goodsPriceSum} where telephone = #{telephone} and goodsID = #{goodsID}")
    boolean modifyCart(int goodsNum, String telephone, int goodsID, Double goodsPriceSum);


    @Delete("delete from cart where telephone=#{telephone} and goodsID = #{goodsID}")
    Boolean deletCart(String telephone, int goodsID);
}
