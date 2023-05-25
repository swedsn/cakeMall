package com.db.service;

import com.db.entity.User;

import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-06 20:23
 */
public interface UserService {

    // 查询所有的用户
    List<User> selectUsers();

    // 通过姓名查询用户
    List<User> selectUsersByName(String username);

    // 通过电话查询用户
    User selectUserByPhone(String telephone);

    // 添加用户
    Boolean addUser(User user);

    // 分页查询
    List<User> selectUsersByPage(Integer pageNum);

    // 得到用户的总数
    Integer getUserNum();

    // 根据条件查询
    List<User> selectUsersByCondition(String telephone, String username, String address);

    Boolean modifyUser(User user);

    Boolean deleteUser(String telephone);

    Boolean userLogin(String telephone, String password);
}
