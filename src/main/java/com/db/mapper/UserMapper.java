package com.db.mapper;

import com.db.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-01 23:00
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where telephone=#{telephone} and passwd=#{passwd}")
    User userLogin(String telephone, String passwd);
    @Select("select * from user")
    List<User> selectUsers();
    List<User> selectUsersByName(String username);
    User selectUserByPhone(String telephone);
    Integer addUser(User user);
    @Select("select * from user limit #{numStart},10")
    List<User> selectUsersByPage(int numStart);

    @Select("select count(*) from user")
    Integer getUserNum();

    List<User> selectUsersByCondition(String telephone, String username, String address);

    @Update("update user set passwd = #{passwd}, username = #{username}, sex = #{sex}, address = #{address}  where telephone = #{telephone}")
    boolean modifyUser(User user);

    @Delete("delete from user where telephone = #{telephone}")
    boolean deleteUser(String telephone);
}
