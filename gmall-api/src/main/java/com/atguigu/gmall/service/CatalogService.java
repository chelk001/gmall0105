package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * Created by clk on 2019/10/13.
 */
public interface CatalogService {
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog1> getCatalog1();
}
