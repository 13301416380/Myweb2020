package com.njcebbank.merchants.controller;

import com.github.pagehelper.PageInfo;
import com.njcebbank.merchants.annotation.UserRoles;
import com.njcebbank.merchants.bo.MerchantBo;
import com.njcebbank.merchants.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/2 17:28
 */
@RestController
public class MerchantCtroller {
    @Autowired
    private MerchantService merchantService;


    //获取所有特约商户
    @UserRoles(roles = {"1","1001"})//自定义权限拦截注解
    @RequestMapping(value = "/getMerchantList", method = RequestMethod.GET)
    public PageInfo<MerchantBo> getPageInfo(@RequestParam Map<String, Object> map) {
        PageInfo<MerchantBo> pageInfomerchantList = merchantService.getMerchantList(map);
        return pageInfomerchantList;
    }

    @RequestMapping(value = "addmerchant", method = RequestMethod.POST)
    public Map<String, Object> addMerchant(Map<String, Object> map) {
        Map<String, Object> result = new HashMap<>();
        MerchantBo merchantBo = new MerchantBo();

        int count = 1;
        if (count == 1) {
            result.put("info", "success");
            result.put("message", "添加成功");
        } else {
            result.put("info", "error");
            result.put("message", "添加失败");
        }
        return result;
    }


}
