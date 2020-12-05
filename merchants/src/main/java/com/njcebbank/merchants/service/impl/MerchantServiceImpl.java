package com.njcebbank.merchants.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.njcebbank.merchants.bo.MerchantBo;
import com.njcebbank.merchants.dao.MerchantDao;
import com.njcebbank.merchants.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author：不许人间见白头 Time：2020/12/3 11:14
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantDao merchantDao;

    //查询所有商户
    @Override
    public PageInfo<MerchantBo> getMerchantList(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageNum").toString()), Integer.parseInt(map.get("pageSize").toString()));
        List<MerchantBo> merchantList = merchantDao.getMerchantList(map);
        PageInfo<MerchantBo> boPageInfo = new PageInfo<>(merchantList);

        return boPageInfo;
    }
}
