package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsSearchParam;
import com.atguigu.gmall.bean.PmsSearchSkuInfo;

import java.util.List;

/**
 * Created by clk on 2019/10/23.
 */
public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
