package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by clk on 2019/10/10.
 */

public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
