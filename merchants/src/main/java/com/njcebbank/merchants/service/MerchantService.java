package com.njcebbank.merchants.service;

import com.github.pagehelper.PageInfo;
import com.njcebbank.merchants.bo.MerchantBo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/3 11:13
 */

public interface MerchantService {
    //查询所有商户信息
    public PageInfo<MerchantBo> getMerchantList(Map<String ,Object> map);
    //查询是否存在商户
    public  int isExistence(Map<String ,Object> map);
    //批量添加特约商户
    public int addMerchants(List<MerchantBo> list);

}
