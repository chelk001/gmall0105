package com.atguigu.gmall.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by clk on 2019/10/26.
 */
public class TestJwt {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("memberId","1");
        map.put("nickname","zhangsan");
        String ip="127.0.0.1";
        String time= new SimpleDateFormat("yyyyMMdd").format(new Date());

        String encode = JwtUtil.encode("2019gmall0105", map, ip + map);
        System.out.println(encode);
    }
}
