package com.db.contorller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.db.entity.Administrator;
import com.db.service.AdministratorService;
import com.db.service.impl.AdministratorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-05-22 10:50
 */

@RestController
@CrossOrigin
public class AdministratorContorller {
    // 后台管理员登陆
    @GetMapping  ("/login")
    public JSON login(Administrator administrator){
        System.out.println(administrator.getUsername()+ administrator.getPasswd());
        AdministratorService administratorService = new AdministratorServiceImpl();

        boolean flag = administratorService.login(administrator);
        //String token = JwtUtils.generateToken(administrator.getUsername());
        JSONObject str = new JSONObject();
        if (flag) {
            str.put("status", true);
            //str.put("token", token);
            str.put("username", administrator.getUsername());
        }
        else {
            str.put("status", false);
        }
        return str;
    }

}
