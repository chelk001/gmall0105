package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsSkuInfo;

import java.util.List;

/**
 * Created by clk on 2019/10/16.
 */
public interface SkuService {
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);


    PmsSkuInfo getSkuById(String skuId);

    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
    List<PmsSkuInfo> getAllSku();
}
