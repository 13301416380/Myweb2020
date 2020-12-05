package com.njcebbank.merchants.service;

import com.njcebbank.merchants.bo.Userinfos;
import org.springframework.stereotype.Repository;

import java.util.Map;


/**
 * @author：不许人间见白头 Time：2020/12/3 14:24
 */
@Repository
public interface LoginService {
    //登录
    public Map<String,Object> logging(String userid, String password);
}
