package com.db.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db.entity.User;
import com.db.service.UserService;
import com.db.service.impl.UserImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author swedsn
 * @version 1.0
 * @date 2022-12-05 16:53
 */

@RestController
@CrossOrigin
public class UserController {
    UserService userService = new UserImpl();

    // 查询所有用户
    @GetMapping("/selectUsers")
    public String selectUsers() {
        List<User> users = userService.selectUsers();
        return JSON.toJSONString(users);
    }

    // 分页展示用户
    @GetMapping("/selectUsersByPage")
    public JSON selectUsersByPage(Integer pageNum) {
        List<User> users = userService.selectUsersByPage(pageNum);
        Integer userNum = userService.getUserNum();
        JSONObject str = new JSONObject();
        str.put("total", userNum);
        str.put("users", users);
        return str;
    }

    // 通过条件查询用户
    @GetMapping("/selectUsersByCondition")
    public JSONObject selectUsersByCondition(String telephone, String username, String address) {
        List<User> users = userService.selectUsersByCondition(telephone, username, address);
        JSONObject str = new JSONObject();
        str.put("total", users.size());
        str.put("users", users);
        return str;
    }

    // 通过电话号码查询用户：验证电话号码是否已经被验证
    @GetMapping("/selectUserByPhone")
    public JSON selectUserByPhone(String telephone) {
        User user = userService.selectUserByPhone(telephone);
        JSONObject str = new JSONObject();
        if (user != null){
            str.put("user", user);
            str.put("exist", true);
        }
        else {
            str.put("exist", false);
        }
        return str;
    }

    // 添加用户
    @PostMapping("/addUser")
    public JSON addUser(@RequestBody User user) {
        Boolean flag = userService.addUser(user);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }

    // 修改用户
    @PostMapping("/modifyUser")
    public JSON modifyUser(@RequestBody User user) {
        Boolean flag = userService.modifyUser(user);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }

    // 删除用户
    @GetMapping("/deleteUser")
    public JSON deleteUser(String telephone) {
        Boolean flag = userService.deleteUser(telephone);
        JSONObject str = new JSONObject();
        str.put("status", flag);
        return str;
    }

    // 前台用户登陆：手机号+密码，登陆成功会返回一个jwt的token作为唯一的凭证
    @GetMapping  ("/userLogin")
    public JSON userLogin(String telephone, String password){
        boolean flag = userService.userLogin(telephone, password);
        User user = userService.selectUserByPhone(telephone);
        String token = JwtUtils.generateToken(user);
        JSONObject str = new JSONObject();
        if (flag) {
            str.put("status", true);
            str.put("token", token);
            str.put("username", user.getUsername());
            str.put("telephone", telephone);
        }
        else {
            str.put("status", false);
        }
        return str;
    }

    //@GetMapping("/verifyToken")
    //public String verifyToken(String token) {
    //    DecodedJWT verify = JwtUtils.getClaimsByToken(token);
    //    if (verify == null){
    //        return JSON.toJSONString(false);
    //    }
    //    else
    //        return JSON.toJSONString(true);
    //}
}
