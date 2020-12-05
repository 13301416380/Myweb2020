package com.njcebbank.merchants.dao;

import com.njcebbank.merchants.bo.MerchantBo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/3 10:47
 */
@Repository
public interface MerchantDao {
    //查询所有商户信息
    public List<MerchantBo> getMerchantList(Map<String ,Object> map);
}
