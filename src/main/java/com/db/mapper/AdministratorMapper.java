package com.db.mapper;

import com.db.entity.Administrator;
import org.apache.ibatis.annotations.Select;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-22 10:53
 */
public interface AdministratorMapper {

    @Select("select * from administrator where username=#{username} and passwd=#{passwd}")
    Administrator login(Administrator administrator);
}
