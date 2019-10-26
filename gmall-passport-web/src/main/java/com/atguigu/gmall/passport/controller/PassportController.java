package com.atguigu.gmall.passport.controller;

import com.atguigu.gmall.bean.UmsMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by clk on 2019/10/26.
 */
@Controller
public class PassportController {

    @RequestMapping("verify")
    @ResponseBody
    public String verify(String token) {
        //通过JWT校验token的真假

        return "success";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(UmsMember umsMember) {

        //调用用户服务验证用户名和密码
        return "token";
    }

    @RequestMapping("index")
    public String index(String ReturnUrl, ModelMap modelMap) {
        modelMap.put("ReturnUrl",ReturnUrl);
        return "index";
    }
}
