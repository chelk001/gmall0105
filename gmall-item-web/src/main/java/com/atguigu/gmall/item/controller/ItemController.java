package com.atguigu.gmall.item.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsSkuAttrValue;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.bean.PmsSkuSaleAttrValue;
import com.atguigu.gmall.service.SkuService;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by clk on 2019/10/18.
 */
@Controller
public class ItemController {

    @Reference
    SkuService sukService;
    @Reference
    SpuService spuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap map) {

        PmsSkuInfo pmsSkuInfo = sukService.getSkuById(skuId);
        //查询销售属性列表
        List<PmsProductSaleAttr> pmsProductSaleAttrList = spuService.getspuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(), skuId);
        //制作hash表
        HashMap<String, String> skuSaleAttrHash = new HashMap<String, String>();
        List<PmsSkuInfo> pmsSkuInfoList = sukService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
        for (PmsSkuInfo skuInfo : pmsSkuInfoList) {
            String v = skuInfo.getId();
            String k = "";
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";
            }
            skuSaleAttrHash.put(k, v);
        }
        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);

        map.put("skuInfo", pmsSkuInfo);
        map.put("spuSaleAttrListCheckBySku", pmsProductSaleAttrList);
        map.put("skuSaleAttrHashJsonStr", skuSaleAttrHashJsonStr);
        return "item";
    }

    @RequestMapping("index")

    public String index(ModelMap modelMap) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("循环数据" + i);
        }
        modelMap.put("list", list);
        return "index";
    }

}
