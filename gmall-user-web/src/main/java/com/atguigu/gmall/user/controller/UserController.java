package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by clk on 2019/10/10.
 */
@RestController
public class UserController {
    @Reference
    UserService userService;


    @RequestMapping("getReceiveAddressByMemberId")
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }
    @RequestMapping("/getAllUser")
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMermber = userService.getAllUser();
        return umsMermber;
    }

    @RequestMapping("/index")
    public String index() {
        return "hello user";
    }
}
