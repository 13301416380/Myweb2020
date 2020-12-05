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
}
